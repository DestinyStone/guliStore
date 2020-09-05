package com.gulistore.maven.gulistoremanagerservice.mapper;

import bean.PmsProductImage;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface PmsProductImageMapper extends Mapper<PmsProductImage>, MySqlMapper<PmsProductImage> {
}
