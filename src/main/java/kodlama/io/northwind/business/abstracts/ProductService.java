package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.Result;
import kodlama.io.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface ProductService {
    DataResult<Collection<Product>> getAll();
    DataResult<Collection<Product>> getAll(int pageNo, int pageSize); // Pageable Part
    DataResult<Collection<Product>> getAllSorted(); // Sorted process

    Result add(Product product);

    Collection<Product> findAllByIdGreaterThan(int productId);

    Collection<Product> findAllByProductNameEquals(String productName);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameContains(String productName);

  /*
    below methods can works..

    DataResult<List<Product>> getByProductNameOrAndCategory(String productName, String categoryId);

    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartingWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
*/

}
