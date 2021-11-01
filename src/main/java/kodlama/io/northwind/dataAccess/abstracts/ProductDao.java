package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    Collection<Product> findAllByIdGreaterThan(int productId);

    Collection<Product> findAllByProductNameEquals(String productName);

    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameContains(String productName);


//    below methods can works..
   List<Product> getByProductNameOrAndCategory(String productName, String categoryId);
//    List<Product> getByCategoryIn(List<Integer> categories);
//    List<Product> getByProductNameStartingWith(String productName);
//    List<Product> getByNameAndCategory(String productName, int categoryId);
//    @Query("From Product where productName = : productName and category.categoryId  = : categoryId")


}
