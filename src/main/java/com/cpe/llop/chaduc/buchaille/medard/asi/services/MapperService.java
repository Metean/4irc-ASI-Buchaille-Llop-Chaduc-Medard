package com.cpe.llop.chaduc.buchaille.medard.asi.services;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

public class MapperService {
    private final ModelMapper modelMapper;

    public MapperService() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    }

    public void map(Object source, Object destination) {
        modelMapper.map(source, destination);
    }


}
