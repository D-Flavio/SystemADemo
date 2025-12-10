package com.example.systemADemo.dtos;

import java.util.concurrent.atomic.AtomicInteger;

public class BaseDTO {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;

    public BaseDTO() {
        this.id = count.incrementAndGet();
    }

    public int getId() {
        return id;
    }
}
