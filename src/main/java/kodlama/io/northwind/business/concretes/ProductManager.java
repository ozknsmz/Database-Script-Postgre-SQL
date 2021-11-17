package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.DataSuccessResult;
import kodlama.io.northwind.core.utilities.results.Result;
import kodlama.io.northwind.core.utilities.results.SuccessResult;
import kodlama.io.northwind.dataAccess.abstracts.ProductDao;
import kodlama.io.northwind.entities.concretes.Product;
import kodlama.io.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<Collection<Product>> getAll() {
        return new DataSuccessResult<List<Product>>
                (this.productDao.findAll(), "Data Listelendi");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Ürün eklendi");
    }

    @Override
    public Collection<Product> findAllByIdGreaterThan(int productId) {
        return this.productDao.findAllByIdGreaterThan(productId);
    }

    @Override
    public Collection<Product> findAllByProductNameEquals(String productName) {
        return this.productDao.findAllByProductNameEquals(productName);
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new DataSuccessResult<Product>
                (this.productDao.getByProductName(productName), "ProductName Listelendi");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
        //business codes

        return new DataSuccessResult<Product>
                (this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>>  getByProductNameContains(String productName){
        return new DataSuccessResult<List<Product>>(
                this.productDao.getByProductNameContains(productName),"All product which contains that:"
        );
    }


    // Pageable Part
    @Override
    public DataResult<Collection<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize); // pageNo-1 => we must pageNo-1 because it starts from 0.
        return new DataSuccessResult<List<Product>>(this.productDao.findAll(pageable).getContent(),"pagable part works!"
    );
    }

    @Override
    public DataResult<Collection<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new DataSuccessResult<List<Product>>(this.productDao.findAll(sort),"pagable part works!"
        );
    }


    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new DataSuccessResult<List<ProductWithCategoryDto>>
                (this.productDao.getProductWithCategoryDetails(), "Data Listelendi");
    }

}






    /*
    @Override
    public DataResult<List<Product>> getByProductNameOrAndCategory(String productName, String categoryId) {
        return new DataSuccessResult<List<Product>>
                (this.productDao.getByProductNameOrAndCategory(productName, categoryId), "ProductName Or AndCategoryId Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return new DataSuccessResult<List<Product>>
                (this.productDao.getByCategoryIn(categories), "CategoryIdIn Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new DataSuccessResult<List<Product>>
                (this.productDao.getByProductNameContains(productName), "ProductNameContains Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartingWith(String productName) {
        return new DataSuccessResult<List<Product>>
                (this.productDao.getByProductNameStartingWith(productName), "ProductNameStartingWith Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new DataSuccessResult<List<Product>>
                (this.productDao.getByNameAndCategory(productName, categoryId), "NameAndCategory Listelendi");
    }*/

