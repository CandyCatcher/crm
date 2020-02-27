package top.candy.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.candy.ssm.dao.BaseDictDao;
import top.candy.ssm.pojo.BaseDict;
import top.candy.ssm.service.BaseDictService;

import java.util.List;

//@Service @Controller @Repository其实是一样的，没有任何区别
@Service
public class BaseDictServiceImpl implements BaseDictService {

    @Autowired
    BaseDictDao baseDictDao;

    @Override
    public List<BaseDict> findByTypeCode(String type_code) {
        return baseDictDao.findByTypeCode(type_code);
    }
}
