package top.candy.ssm.service;

import top.candy.common.utils.PageBean;
import top.candy.ssm.pojo.Customer;
import top.candy.ssm.pojo.QueryVo;

public interface CustomerService {
    /*
        表现层所做的就是获取数据，将所需的数据显示在页面上
        对于当前页面是需要一个pageBean
        持久层就是用来进行查询的或者存储的
        如果查出来的数据不是页面所需要的，那么就需要进行组装，这个过程发生在service层
    */
    public PageBean findByPage(QueryVo queryVo);
    public Customer findByID(long id);
    public void update(Customer customer);
    public void delete(long id);
}
