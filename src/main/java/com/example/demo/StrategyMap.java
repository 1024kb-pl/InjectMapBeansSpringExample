package com.example.demo;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;

@Component
public class StrategyMap {
    private List<Strategy> strategyList;
    private Logger logger;
    private final EnumMap<StrategyKey, Strategy> strategies;

    @Autowired
    public StrategyMap(List<Strategy> strategyList, Logger logger) {
        this.strategyList = strategyList;
        this.logger = logger;
        strategies = getStrategiesMap();
    }

    public EnumMap<StrategyKey, Strategy> getStrategies() {
        return strategies;
    }

    private EnumMap<StrategyKey, Strategy> getStrategiesMap() {
        EnumMap<StrategyKey, Strategy> strategyEnumMap = new EnumMap<>(StrategyKey.class);
        logger.info("Creating bean strategy map...");

        strategyList.forEach(strategy -> StrategyKey.getStrategyKey(strategy.getClass().getSimpleName())
                .ifPresent(key -> strategyEnumMap.put(key, strategy)));

        return strategyEnumMap;
    }

}
