package com.gulistore.maven.gulistoremanagerservice.mapper;

import bean.PmsSkuSaleAttrValue;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface PmsSkuSaleAttrValueMapper extends Mapper<PmsSkuSaleAttrValue>, MySqlMapper<PmsSkuSaleAttrValue> {
}
