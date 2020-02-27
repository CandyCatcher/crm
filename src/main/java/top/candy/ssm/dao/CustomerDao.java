package top.candy.ssm.dao;

import top.candy.common.utils.PageBean;
import top.candy.ssm.controller.CustomerController;
import top.candy.ssm.pojo.Customer;
import top.candy.ssm.pojo.QueryVo;

import java.util.List;

public interface CustomerDao {
    public List<Customer> findByPage(QueryVo queryVo);
    public int getTotalCount(QueryVo queryVo);
    public Customer findByID(long id);
    public void update(Customer customer);
    public void delete(long id);
}
