package be.bluemagma.springbootcqarchitecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import be.bluemagma.springbootcqarchitecture.cqrs.DispatchableHandler;
import be.bluemagma.springbootcqarchitecture.cqrs.DispatchableProcessor;
import be.bluemagma.springbootcqarchitecture.cqrs.DispatchableTimer;

@SpringBootApplication
public class SpringBootCqArchitectureApplication {

  private final ApplicationContext applicationContext;

  public SpringBootCqArchitectureApplication(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringBootCqArchitectureApplication.class, args);
  }

  @Bean
  public DispatchableHandler dispatchableHandler() {
    return new DispatchableTimer(new DispatchableProcessor(this.applicationContext));
  }
}
