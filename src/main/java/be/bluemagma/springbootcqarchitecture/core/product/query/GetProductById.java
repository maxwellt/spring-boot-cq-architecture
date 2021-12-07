package be.bluemagma.springbootcqarchitecture.core.product.query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import be.bluemagma.springbootcqarchitecture.core.product.Product;
import be.bluemagma.springbootcqarchitecture.core.product.ProductRepository;
import be.bluemagma.springbootcqarchitecture.cqrs.HandledBy;
import be.bluemagma.springbootcqarchitecture.cqrs.query.Query;
import be.bluemagma.springbootcqarchitecture.cqrs.query.QueryHandler;
import lombok.Value;

@Value
@HandledBy(handler = GetProductByIdHandler.class)
public class GetProductById implements Query<Optional<Product>> {

  Long id;
}

@Service
@Transactional
class GetProductByIdHandler implements QueryHandler<GetProductById, Optional<Product>> {

  private final ProductRepository productRepository;

  GetProductByIdHandler(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Optional<Product> handle(GetProductById query) {
    return this.productRepository.findById(query.getId());
  }
}
