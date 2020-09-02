package com.gulistore.maven.gulistoremanagerservice;

import com.gulistore.maven.gulistoremanagerservice.mapper.PmsBaseCatalog1Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GulistoreManagerServiceTest {

    @Autowired
    private PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Test
    private void aaa() {
        System.out.println("sss");
        pmsBaseCatalog1Mapper.selectAll().stream().forEach(System.out::println);
        System.out.println("ssssss");
    }
}
