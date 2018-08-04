package csu.skx.sell.service;

import java.util.List;
import csu.skx.sell.domain.ProductCategory;

public interface CategoryService {

    ProductCategory getOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
