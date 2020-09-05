package com.gulistore.maven.gulistoremanagerservice.mapper;

import bean.PmsProductSaleAttrValue;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface PmsProductSaleAttrValueMapper extends Mapper<PmsProductSaleAttrValue>, MySqlMapper<PmsProductSaleAttrValue> {
}
