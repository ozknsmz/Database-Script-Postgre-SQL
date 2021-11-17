package kodlama.io.northwind.api.controllers;

import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.Result;
import kodlama.io.northwind.entities.concretes.Product;
import kodlama.io.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/products")

public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    /* GET MAPPING PART */

    // to get all products
    @GetMapping("/get/All")
    public DataResult<Collection<Product>> getAll() {
        return this.productService.getAll();
    }

    // to get productId which greater than input numbers
    @GetMapping("/get/All/greaterThan/{productId}")
    public Collection<Product> getAllGreater(@RequestParam int productId) {
        return this.productService.findAllByIdGreaterThan(productId);
    }

    //to get products by use equals method
    @GetMapping("get/All/equals/{productname}")
    public Collection<Product> getEqualsName(@RequestParam String productName) {
        return this.productService.findAllByProductNameEquals(productName);
    }

    //to get products by use productName
    @GetMapping("/get/productName")
    public DataResult<Product> getProductName(@RequestParam String productName) {
        return this.productService.getByProductName(productName);
    }

    // to get productName and categoryId products
    @GetMapping("/get/ProductName-And-CategoryId")
    public DataResult<Product>
    getByProductNameAndCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
        return this.productService.getByProductNameAndCategory_CategoryId
                (productName, categoryId);
    }

    // to search
    @GetMapping("/get/ProductName/Search")
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return this.productService.getByProductNameContains(productName);
    }

    // to get page and to take input size in a page.
    @GetMapping("/get/All/Page")
    DataResult<Collection<Product>> getAll(int pageNo, int pageSize){
        return productService.getAll(pageNo,pageSize);
    }


    @GetMapping("/get/All/Sorted/Desc")
    DataResult<Collection<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }


    @GetMapping("/get/ProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDetails();
    }


    /* POST MAPPING PART */

    // to add products
    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return this.productService.add(product);
    }

}
