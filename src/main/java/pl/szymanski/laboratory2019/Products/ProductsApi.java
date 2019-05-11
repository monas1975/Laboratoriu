package pl.szymanski.laboratory2019.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsApi {

  private ProductsRepo productsRepo;

  @Autowired
  public ProductsApi(ProductsRepo productsRepo){
      this.productsRepo = productsRepo;
  }


  @GetMapping("/showProduct")
  public Iterable<Products> show(){

      return productsRepo.findAll();
  }


}
