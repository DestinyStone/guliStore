package service;

import bean.PmsSkuInfo;

import java.util.List;

public interface PmsSkuInfoService {
    String insertPmsSkuInfo(PmsSkuInfo pmsSkuInfo);

    PmsSkuInfo selectById(Long skuId);

    List<PmsSkuInfo> selectAll();
}
