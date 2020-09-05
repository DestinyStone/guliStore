package com.gulistore.maven.gulistoremanagerservice.mapper;

import bean.PmsBaseAttrValue;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

@Repository
public interface PmsBaseAttrValueMapper extends Mapper<PmsBaseAttrValue>, InsertListMapper<PmsBaseAttrValue> {
}
