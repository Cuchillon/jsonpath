package com.ferick.model;

import com.google.gson.JsonElement;

public class JsonValue {

    private final JsonElement jsonElement;

    public JsonValue(JsonElement jsonElement) {
        this.jsonElement = jsonElement;
    }

    public JsonElement getJsonElement() {
        return jsonElement;
    }
}
