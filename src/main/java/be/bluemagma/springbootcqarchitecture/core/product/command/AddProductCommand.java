package be.bluemagma.springbootcqarchitecture.core.product.command;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

import be.bluemagma.springbootcqarchitecture.core.product.Product;
import be.bluemagma.springbootcqarchitecture.core.product.ProductRepository;
import be.bluemagma.springbootcqarchitecture.cqrs.Command;
import be.bluemagma.springbootcqarchitecture.cqrs.HandledBy;
import be.bluemagma.springbootcqarchitecture.cqrs.command.CommandHandler;
import lombok.Value;

@Value
@HandledBy(handler = AddProductCommandHandler.class)
public class AddProductCommand implements Command<Long> {

  String name;
  BigDecimal unitPrice;
  String description;
}

@Service
@Transactional
class AddProductCommandHandler implements CommandHandler<AddProductCommand, Long> {

  private final ProductRepository productRepository;

  AddProductCommandHandler(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Long handle(AddProductCommand command) {
    if (command.getUnitPrice().compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("Price of product cannot be less than 0");
    }

    Optional<Product> existingProductWithName = this.productRepository.findByNameIgnoreCase(command.getName());
    if (existingProductWithName.isPresent()) {
      throw new IllegalArgumentException(String.format("%s is already defined as product", command.getName()));
    }

    Product productToSave = new Product(command.getName(), command.getUnitPrice(), command.getDescription());
    Product savedProduct = this.productRepository.save(productToSave);

    return savedProduct.getId();
  }
}
