package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class FirstStrategy implements Strategy {
    @Override
    public String doSth(String action) {
        return action.toUpperCase();
    }
}
