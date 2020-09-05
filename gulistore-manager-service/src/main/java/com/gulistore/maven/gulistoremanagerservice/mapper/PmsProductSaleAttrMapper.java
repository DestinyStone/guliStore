package com.gulistore.maven.gulistoremanagerservice.mapper;

import bean.PmsProductSaleAttr;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface PmsProductSaleAttrMapper extends Mapper<PmsProductSaleAttr>, MySqlMapper<PmsProductSaleAttr> {
}
