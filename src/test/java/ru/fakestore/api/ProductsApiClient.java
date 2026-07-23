package ru.fakestore.api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ProductsApiClient extends BaseApiClient{
    
    private static final String PRODUCTS_ENDPOINT = "/products";

    public Response getProductById(int productId){
        return given()
                .spec(getBaseSpec())
                .pathParam("id", productId)
            .when()
                .get(PRODUCTS_ENDPOINT + "/{id}")
            .then()
                .extract().response();
    }

    public Response createProduct(String requestBody){
        return given()
                .spec(getBaseSpec())
                .body(requestBody)
            .when()
                .post(PRODUCTS_ENDPOINT)
            .then()
             .extract().response();
    }
}
