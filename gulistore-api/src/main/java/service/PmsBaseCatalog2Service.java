package service;

import bean.PmsBaseCatalog2;

import java.util.List;

public interface PmsBaseCatalog2Service {
    List<PmsBaseCatalog2> selectCatalog2ByCatalog1Id(Long id);
}
