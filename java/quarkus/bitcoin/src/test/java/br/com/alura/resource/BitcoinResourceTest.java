package br.com.alura.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class BitcoinResourceTest {

    @Test
    void shouldReturnBitcoins() {
        RestAssured
                .given()
                .get("/bitcoins")
                .then()
                .statusCode(200);
    }

}
