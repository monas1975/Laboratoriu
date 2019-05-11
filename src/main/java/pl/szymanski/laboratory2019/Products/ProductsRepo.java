package pl.szymanski.laboratory2019.Products;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;

public interface ProductsRepo extends CrudRepository<Products,Long> {
}
