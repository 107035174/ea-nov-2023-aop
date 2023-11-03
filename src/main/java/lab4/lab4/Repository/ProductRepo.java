package lab4.lab4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab4.lab4.Model.Catagory;
import lab4.lab4.Model.Product;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByPriceGreaterThan(double minPrice);
    List<Product> findByCatagoryAndPriceLessThan(Catagory cat, double maxPrice);
    List<Product> findByNameContaining(String name);
}
