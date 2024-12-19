package com.automation.demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PetStoreApiTestNGTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void testAddPet() {
        String newPet = """
                    {
                        "id": 12345,
                        "name": "Doggie",
                        "status": "available"
                    }
                """;
        Response response = RestAssured.given().header("Content-Type", "application/json")
                .body(newPet).post("/pet");

        Assert.assertEquals(response.getStatusCode(),200, "Status code should be 200");
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Doggie"), "Response should contain pet name 'Doggie'");
        Assert.assertTrue(responseBody.contains("available"), "Response should indicate the pet is 'available'");
    }

    @Test
    public void testGetPetById(){
        Response response = RestAssured.given().pathParam("petId",12345).get("/pet/{petId}");
        Assert.assertEquals(response.getStatusCode(),200,"Status code should be 200");
        String responseName = response.jsonPath().getString("name");
        Assert.assertEquals("Doggie",responseName);

    }
}
