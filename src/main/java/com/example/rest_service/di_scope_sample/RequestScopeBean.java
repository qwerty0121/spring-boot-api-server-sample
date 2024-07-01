package com.example.rest_service.di_scope_sample;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class RequestScopeBean {

  private final AtomicLong counter = new AtomicLong();

  public long count() {
    return counter.getAndIncrement();
  }

}
