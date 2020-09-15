package com.gulistore.maven.gulistoremanagerservice;

import com.gulistore.maven.gulistoremanagerservice.mapper.PmsBaseAttrInfoMapper;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsBaseAttrValueMapper;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsBaseCatalog1Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GulistoreManagerServiceTest {

   @Autowired
   private PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

   @Autowired
   private PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

   @Autowired
   private PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Test
    public void aaa() {

    }
}
