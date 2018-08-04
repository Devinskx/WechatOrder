package csu.skx.sell.repository;

import java.util.List;
import csu.skx.sell.domain.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String > {


    List<ProductInfo> findByProductStatus(Integer productStatus);
}
