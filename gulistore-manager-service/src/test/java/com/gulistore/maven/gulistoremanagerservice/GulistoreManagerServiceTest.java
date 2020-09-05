package com.gulistore.maven.gulistoremanagerservice;

import bean.PmsBaseCatalog1;
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
        List<PmsBaseCatalog1> list = new ArrayList<>();
        PmsBaseCatalog1 zszs = PmsBaseCatalog1.builder().name("zszs").build();

        list.add(zszs);
        pmsBaseCatalog1Mapper.insertList(list);

    }
}
