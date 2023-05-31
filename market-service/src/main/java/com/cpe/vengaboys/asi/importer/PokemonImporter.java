package com.cpe.vengaboys.asi.importer;

import com.cpe.vengaboys.asi.models.Card;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.InputStream;
import java.util.List;
public class PokemonImporter {
    private static final Logger log = LoggerFactory.getLogger(PokemonImporter.class);

    private List<Card> pokemonCards;

    public PokemonImporter() {
        try {
            InputStream fileResource = ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX + "json/pokemons.json").openStream();

            ObjectMapper objectMapper = new ObjectMapper();
            pokemonCards = objectMapper.readValue(fileResource, new TypeReference<>() {});

            log.info(pokemonCards.toString());
        } catch (Exception e) {
            log.error("Error caused by " + e.toString());
        }
    }

    public List<Card> getPokemonCards() {
        return pokemonCards;
    }

}

