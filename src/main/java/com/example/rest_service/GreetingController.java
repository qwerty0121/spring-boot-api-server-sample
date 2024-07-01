package com.example.rest_service;

// import org.springframework.beans.factory.annotation.Autowired;

// import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  // private static final String template = "Hello, %s!";
  // private final AtomicLong counter = new AtomicLong();

  private GreetingService greetingService;

  // @Autowired
  public GreetingController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    // return new Greeting(counter.incrementAndGet(), String.format(template,
    // name));
    return greetingService.greeting(name);
  }

}
