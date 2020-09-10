package com.gulistore.maven.gulistoremanagerservice;

import bean.PmsProductSaleAttr;
import com.alibaba.fastjson.JSONObject;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsBaseAttrValueMapper;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsBaseCatalog1Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class GulistoreManagerServiceTest {

   @Autowired
   private PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

   @Autowired
   private PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Test
    public void aaa() {

        PmsProductSaleAttr pmsProductSaleAttr = PmsProductSaleAttr.builder().productId(10L).id(20L).saleAttrId(20L).build();


        List<PmsProductSaleAttr> pmsProductSaleAttrList = new ArrayList<>();
        pmsProductSaleAttrList.add(pmsProductSaleAttr);

        String s = JSONObject.toJSONString(pmsProductSaleAttrList);

        System.out.println(s);

        List<PmsProductSaleAttr> pmsProductSaleAttrList1 = JSONObject.parseArray(s, PmsProductSaleAttr.class);


    }
}
