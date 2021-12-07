package be.bluemagma.springbootcqarchitecture.core.product.query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import be.bluemagma.springbootcqarchitecture.core.product.Product;
import be.bluemagma.springbootcqarchitecture.core.product.ProductRepository;
import be.bluemagma.springbootcqarchitecture.cqrs.HandledBy;
import be.bluemagma.springbootcqarchitecture.cqrs.query.Query;
import be.bluemagma.springbootcqarchitecture.cqrs.query.QueryHandler;

@HandledBy(handler = GetAllProductsQueryHandler.class)
public class GetAllProductsQuery implements Query<List<Product>> {
}

@Service
@Transactional
class GetAllProductsQueryHandler implements QueryHandler<GetAllProductsQuery, List<Product>> {

  private final ProductRepository productRepository;

  GetAllProductsQueryHandler(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public List<Product> handle(GetAllProductsQuery query) {
    return this.productRepository.findAll();
  }
}