package com.example.demo;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Context {

    private StrategyMap strategies;
    private final Logger logger;

    @Autowired
    public Context(StrategyMap strategies, Logger logger) {
        this.strategies = strategies;
        this.logger = logger;
    }

    public void doSth(String key, String sth) {
        StrategyKey strategyKey = StrategyKey.getStrategyKey(key)
                .orElseThrow(IllegalArgumentException::new);

        final String result = strategies.getStrategies().get(strategyKey).doSth(sth);
        logger.info("DoSth result: {}", result);
    }
}
