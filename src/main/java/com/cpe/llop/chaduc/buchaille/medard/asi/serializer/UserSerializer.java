package com.cpe.llop.chaduc.buchaille.medard.asi.serializer;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class UserSerializer extends JsonSerializer<User> {

    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {

        jsonGenerator.writeStartObject();

        jsonGenerator.writeNumberField("id", user.getId());
        jsonGenerator.writeStringField("email", user.getEmail());
        jsonGenerator.writeStringField("username", user.getUsername());

        if (user.getMoney() != null) {
            jsonGenerator.writeNumberField("money", user.getMoney());
        } else {
            jsonGenerator.writeNullField("money");
        }

        jsonGenerator.writeStringField("password", user.getPassword());

        jsonGenerator.writeEndObject();
    }


}
