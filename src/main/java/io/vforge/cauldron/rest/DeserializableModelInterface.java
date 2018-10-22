package io.vforge.cauldron.rest;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(value = {"type"})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Subclass1.class, name = "SUBCLASS1"),
        @JsonSubTypes.Type(value = Subclass2.class, name = "SUBCLASS2")
})
public interface DeserializableModelInterface {

}
