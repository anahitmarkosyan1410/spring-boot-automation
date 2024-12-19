package com.automation.demo;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PetStoreApiTest {


    static {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void addPetTest() {
        String newPet = """
            {
                "id": 12345,
                "name": "Doggie",
                "status": "available"
            }
        """;

        given()
                .header("Content-Type", "application/json")
                .body(newPet)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .body("name", equalTo("Doggie"))
                .body("status", equalTo("available"));
    }
}
