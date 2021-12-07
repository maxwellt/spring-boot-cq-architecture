package be.bluemagma.springbootcqarchitecture;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.stream.Stream;

import be.bluemagma.springbootcqarchitecture.core.product.Product;
import be.bluemagma.springbootcqarchitecture.core.product.ProductRepository;

@Component
public class DataInit {

  private final ProductRepository productRepository;

  public DataInit(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @EventListener(ApplicationStartedEvent.class)
  public void onApplicationStartup() {
    Stream.of(
        new Product("Product 1", new BigDecimal("9.99"), "Product 1 description"),
        new Product("Product 2", new BigDecimal("4.99"), "Product 2 description"),
        new Product("Product 3", new BigDecimal("5.99"), "Product 3 description"),
        new Product("Product 4", new BigDecimal("6.99"), "Product 4 description"),
        new Product("Product 5", new BigDecimal("7.99"), "Product 5 description")
    ).forEach(this.productRepository::save);
  }
}
