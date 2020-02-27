package top.candy.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.candy.common.utils.PageBean;
import top.candy.ssm.dao.CustomerDao;
import top.candy.ssm.pojo.Customer;
import top.candy.ssm.pojo.QueryVo;
import top.candy.ssm.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public PageBean findByPage(QueryVo queryVo) {
        PageBean pageBean = new PageBean<Customer>();
        List<Customer> customerList = customerDao.findByPage(queryVo);
        int totalCount = customerDao.getTotalCount(queryVo);

        pageBean.setCurrentPage(queryVo.getCurrentPage());
        pageBean.setList(customerList);
        pageBean.setPageSize(queryVo.getPageSize());
        pageBean.setTotalCount(totalCount);

        return pageBean;
    }

    @Override
    public Customer findByID(long id) {
        return customerDao.findByID(id);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void delete(long id) {
        customerDao.delete(id);
    }

}
