package com.gulistore.maven.gulistoremanagerservice.mapper;

import bean.PmsSkuImage;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface PmsSkuImageMapper extends Mapper<PmsSkuImage>, MySqlMapper<PmsSkuImage> {
}
