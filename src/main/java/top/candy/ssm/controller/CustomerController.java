package top.candy.ssm.controller;

import com.alibaba.druid.stat.TableStat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.candy.common.utils.PageBean;
import top.candy.ssm.pojo.BaseDict;
import top.candy.ssm.pojo.Customer;
import top.candy.ssm.pojo.QueryVo;
import top.candy.ssm.service.BaseDictService;
import top.candy.ssm.service.CustomerService;

import java.util.List;

@Controller
public class CustomerController {

    @Value("${base_dict.source}")
    private String baseDictSource;
    @Value("${base_dict.industry}")
    private String baseDictIndustry;
    @Value("${base_dict.level}")
    private String baseDictLevel;

    @Autowired
    private BaseDictService baseDictService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public String list(QueryVo queryVo, Model model) {
        //这里出现硬编码了
        List<BaseDict> sourceList = baseDictService.findByTypeCode(baseDictSource);
        List<BaseDict> industryList = baseDictService.findByTypeCode(baseDictIndustry);
        List<BaseDict> levelList = baseDictService.findByTypeCode(baseDictLevel);
        //初始化查询数据
        model.addAttribute("sourceList", sourceList);
        model.addAttribute("industryList", industryList);
        model.addAttribute("levelList", levelList);

        if (queryVo.getCurrentPage() == 0) {
            queryVo.setCurrentPage(1);
        }
        if (queryVo.getPageSize() == 0) {
            queryVo.setPageSize(5);
        }
        queryVo.setStart((queryVo.getCurrentPage() - 1) * queryVo.getPageSize());

        model.addAttribute("custSource", queryVo.getCustSource());
        model.addAttribute("custIndustry", queryVo.getCustIndustry());
        model.addAttribute("custLevel", queryVo.getCustLevel());
        model.addAttribute("custName", queryVo.getCustName());

        //获取分页数据
        PageBean pageBean = customerService.findByPage(queryVo);
        model.addAttribute("page",pageBean);

        return "customer";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    @ResponseBody
    @JsonIgnoreProperties({ "cust_user_id", "cust_creat_id","cust_createtime" })
    public Customer edit(@RequestParam("id") long id) {
        Customer customer = customerService.findByID(id);
        //需要返回json字符串，接一个注解即可
        return customer;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Boolean update(Customer customer) {
        try {
            customerService.update(customer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Boolean delete(long id) {
        try {
            customerService.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
