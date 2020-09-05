package com.gulistore.maven.gulistoremanagerservice.mapper;

import bean.PmsBaseCatalog1;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface PmsBaseCatalog1Mapper extends Mapper<PmsBaseCatalog1>, MySqlMapper<PmsBaseCatalog1> {
}
