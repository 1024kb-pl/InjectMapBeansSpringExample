package com.example.demo;


import java.util.Arrays;
import java.util.Optional;

public enum StrategyKey {
    FIRST_STRATEGY("FirstStrategy"),
    SECOND_STRATEGY("SecondStrategy");

    private final String strategyName;

    StrategyKey(String strategyName) {
        this.strategyName = strategyName;
    }

    public static Optional<StrategyKey> getStrategyKey(String strategyName) {
        return Arrays.asList(StrategyKey.values()).stream()
                .filter(strategy -> strategy.strategyName.equals(strategyName))
                .findFirst();
    }
}
