package service;

import bean.PmsSkuInfo;

public interface PmsSkuInfoService {
    String insertPmsSkuInfo(PmsSkuInfo pmsSkuInfo);

    PmsSkuInfo selectById(Long skuId);
}
