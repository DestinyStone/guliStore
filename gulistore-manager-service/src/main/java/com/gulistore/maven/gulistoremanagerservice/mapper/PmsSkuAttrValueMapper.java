package com.gulistore.maven.gulistoremanagerservice.mapper;

import bean.PmsSkuAttrValue;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface PmsSkuAttrValueMapper extends Mapper<PmsSkuAttrValue>, MySqlMapper<PmsSkuAttrValue> {
}
