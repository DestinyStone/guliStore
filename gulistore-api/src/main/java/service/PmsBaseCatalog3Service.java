package service;

import bean.PmsBaseCatalog3;

import java.util.List;

public interface PmsBaseCatalog3Service {
    List<PmsBaseCatalog3> selectCatalog3ByCatalog2Id(Long id);
}
