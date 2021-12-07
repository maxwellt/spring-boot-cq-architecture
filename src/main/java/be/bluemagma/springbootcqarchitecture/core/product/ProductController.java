package be.bluemagma.springbootcqarchitecture.core.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import be.bluemagma.springbootcqarchitecture.core.product.command.AddProductCommand;
import be.bluemagma.springbootcqarchitecture.core.product.query.GetAllProductsQuery;
import be.bluemagma.springbootcqarchitecture.core.product.query.GetProductById;
import be.bluemagma.springbootcqarchitecture.cqrs.DispatchableHandler;

@RestController
@RequestMapping("/product")
public class ProductController {

  private final DispatchableHandler dispatchableHandler;

  public ProductController(DispatchableHandler dispatchableProcessor) {
    this.dispatchableHandler = dispatchableProcessor;
  }

  @GetMapping
  public ResponseEntity<?> getAll() {
    GetAllProductsQuery getAllProductsQuery = new GetAllProductsQuery();
    List<Product> getAllProductsResponse = this.dispatchableHandler.dispatch(getAllProductsQuery);

    return ResponseEntity.ok(getAllProductsResponse);
  }

  @GetMapping(value = "/{productId}")
  public ResponseEntity<?> getById(@PathVariable final Long productId) {
    GetProductById getProductByIdQuery = new GetProductById(productId);
    Optional<Product> getProductByIdResponse = this.dispatchableHandler.dispatch(getProductByIdQuery);

    if (getProductByIdResponse.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    Product product = getProductByIdResponse.get();
    return ResponseEntity.ok(product);
  }

  @PutMapping
  public ResponseEntity<?> add(@RequestBody final AddProductCommand command) {
    Long productId = this.dispatchableHandler.dispatch(command);

    URI createdUri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(productId)
        .toUri();

    return ResponseEntity.created(createdUri).build();
  }
}
