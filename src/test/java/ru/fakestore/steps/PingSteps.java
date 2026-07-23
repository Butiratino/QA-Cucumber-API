package ru.fakestore.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import ru.fakestore.api.ProductsApiClient;
import ru.fakestore.models.Product;

public class PingSteps {
    
    private ProductsApiClient productsClient = new ProductsApiClient();
    private Response response;

    @Когда("я запрашиваю товар с ID {int}")
    public void requestProductById(int id){
        response = productsClient.getProductById(id);
    }
    @Тогда("сервер возращает успешный статус код {int}")
    public void verifyStatusCode(int exceptedStatusCode){
        Assertions.assertEquals(exceptedStatusCode, response.statusCode(), "Несовпадение по статус коду");
    }
    @И("название товара соответствует {string}")
    public void verifyProductName(String exceptedName){
        Product product = response.as(Product.class);
        Assertions.assertEquals(exceptedName, product.getTitle(), "Название товара отличается");
    }
}
