package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class SecondStrategy implements Strategy {
    @Override
    public String doSth(String action) {
        return "Action: " + action.toLowerCase();
    }
}
