package com.gulistore.maven.gulistoremanagerservice.mapper;

import bean.PmsProductSaleAttr;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

@Repository
public interface PmsProductSaleAttrMapper extends Mapper<PmsProductSaleAttr>, MySqlMapper<PmsProductSaleAttr> {

    /**
     *
     * @param spuId
     * @return  销售属性， 销售属性对应的值， 以及该skuId对应的销售属性值是否被选中
     */
    List<PmsProductSaleAttr> selectBySkuId(@Param("skuId") Long skuId);
}
