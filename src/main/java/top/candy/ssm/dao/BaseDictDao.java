package top.candy.ssm.dao;

import top.candy.ssm.pojo.BaseDict;

import java.util.List;

public interface BaseDictDao {
    public List<BaseDict> findByTypeCode(String type_code);
}
