package com.ferick;

import com.google.gson.JsonParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GetTest {

    private final JsonPath jsonPath = new JsonPath();

    @ParameterizedTest
    @MethodSource("stringJsonProvider")
    void getStringValue(String json, String path) {
        var jsonElement = JsonParser.parseString(json);
        var value = jsonPath.getStringValue(jsonElement, path);
        assertEquals("value", value);
    }

    @ParameterizedTest
    @MethodSource("numberJsonProvider")
    void getNumberValue(String json, String path) {
        var jsonElement = JsonParser.parseString(json);
        var value = jsonPath.getNumberValue(jsonElement, path);
        assertEquals(1, value.intValue());
    }

    @ParameterizedTest
    @MethodSource("booleanJsonProvider")
    void getBooleanValue(String json, String path) {
        var jsonElement = JsonParser.parseString(json);
        var value = jsonPath.getBooleanValue(jsonElement, path);
        assertEquals(Boolean.TRUE, value);
    }

    static Stream<Arguments> stringJsonProvider() {
        return Stream.of(
                arguments("{\"id\":{\"sub_id\":\"value\"}}", "id.sub_id"),
                arguments("{\"id\":{\"sub_id\":[\"value\",\"value2\"]}}", "id.sub_id[0]"),
                arguments("{\"id\":[{\"sub_id\":\"value\"},{\"sub_id\":\"value2\"}]}", "id[0].sub_id")
        );
    }

    static Stream<Arguments> numberJsonProvider() {
        return Stream.of(
                arguments("[1,2]", "[0]"),
                arguments("{\"id\":1}", "id"),
                arguments("{\"id\":[1,2]}", "id[0]")
        );
    }

    static Stream<Arguments> booleanJsonProvider() {
        return Stream.of(
                arguments("[{\"id\":true},{\"id\":false}]", "[0].id")
        );
    }
}