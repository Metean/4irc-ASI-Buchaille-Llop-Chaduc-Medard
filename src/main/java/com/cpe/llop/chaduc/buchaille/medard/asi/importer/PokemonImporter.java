package com.cpe.llop.chaduc.buchaille.medard.asi.importer;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.util.ResourceUtils;

import java.io.File;

import java.util.List;
public class PokemonImporter {
    @Value("classpath:static/pokemons.json")
    Resource pokemonFile;

    private static final Logger log = LoggerFactory.getLogger(PokemonImporter.class);

    private List<Card> pokemonCards;

    public PokemonImporter() {
        try {
            File fileResource = ResourceUtils.getFile("classpath:static/pokemons.json");

            ObjectMapper objectMapper = new ObjectMapper();
            List<Card> cards = objectMapper.readValue(fileResource, new TypeReference<>() {});

            log.info(cards.toString());
        } catch (Exception e) {
            log.error("Error caused by " + e.toString());
        }

    }

    public List<Card> getPokemonCards() {
        return pokemonCards;
    }

}

