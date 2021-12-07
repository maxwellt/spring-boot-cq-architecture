package be.bluemagma.springbootcqarchitecture.core.product;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(of = {"id", "name", "unitPrice", "description"})
public class Product {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private BigDecimal unitPrice;
  private String description;

  public Product(String name, BigDecimal unitPrice, String description) {
    this.name = name;
    this.unitPrice = unitPrice;
    this.description = description;
  }
}
