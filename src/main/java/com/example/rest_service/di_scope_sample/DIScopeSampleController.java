package com.example.rest_service.di_scope_sample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DIScopeSampleController {

  private final RequestScopeBean requestScopeCounter;

  private final SingletonBean singletonCounter;

  public DIScopeSampleController(RequestScopeBean counter, SingletonBean singletonCounter) {
    this.requestScopeCounter = counter;
    this.singletonCounter = singletonCounter;
  }

  @GetMapping("/di_scope_sample")
  public String get() {
    List<Long> requestScopeList = new ArrayList<>();
    requestScopeList.add(requestScopeCounter.count());
    requestScopeList.add(requestScopeCounter.count());
    requestScopeList.add(requestScopeCounter.count());

    List<Long> singletonList = new ArrayList<>();
    singletonList.add(singletonCounter.count());
    singletonList.add(singletonCounter.count());
    singletonList.add(singletonCounter.count());

    return requestScopeList.toString() + ":" + singletonList.toString();
  }

}
