package io.vforge.cauldron.rest;

import com.fasterxml.jackson.databind.deser.AbstractDeserializer;

public class ResponseModel<T extends AbstractDeserializer> {

    private T body;

    public ResponseModel(T body) {
        this.body = body;
    }

    public T getBody() {
        return body;
    }
}
