package com.cpe.llop.chaduc.buchaille.medard.asi.serializer;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class CardSerializer extends JsonSerializer<Card> {

    @Override
    public void serialize(Card card, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {

        jsonGenerator.writeStartObject();

        jsonGenerator.writeNumberField("id", card.getId());
        jsonGenerator.writeNumberField("price", card.getPrice());
        jsonGenerator.writeStringField("name", card.getName());
        jsonGenerator.writeStringField("description", card.getDescription());

        jsonGenerator.writeStringField("imageUrl", card.getImageUrl());

        jsonGenerator.writeNumberField("health", card.getHp());
        jsonGenerator.writeNumberField("attack", card.getAttack());
        jsonGenerator.writeNumberField("defense", card.getDefense());


        jsonGenerator.writeStringField("type1", card.getType1());

        if (card.getType2() != null) {
            jsonGenerator.writeStringField("type2", card.getType2());
        } else {
            jsonGenerator.writeNullField("type2");
        }


        jsonGenerator.writeEndObject();
    }


}
