package be.bluemagma.springbootcqarchitecture.core.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

  Optional<Product> findByNameIgnoreCase(final String name);
}
