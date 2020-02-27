package top.candy.ssm.service;

import top.candy.ssm.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {
    public List<BaseDict> findByTypeCode(String type_code);
}
