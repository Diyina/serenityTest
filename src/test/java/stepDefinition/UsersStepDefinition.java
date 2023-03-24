package stepDefinition;

import static org.hamcrest.Matchers.equalTo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class UsersStepDefinition {

  private static final String URL = "https://dummyjson.com/users/{id}";
  public Response response;

  @Given("I send a {int} request to endpoint")
  public void sendRequest(int id) {
    response =
        SerenityRest.given()
            .contentType("application/json")
            .header("Content-Type", "application/json")
            .pathParams("id", id)
            .when()
            .get(URL);
  }

  @Then("the API should return status {int}")
  public void verifyResponse(int status) {
    SerenityRest.restAssuredThat(response -> response.statusCode(status));
  }

  @And("Response should contains {word}")
  public void verifyResponseContent(String expectedName) {
    SerenityRest.restAssuredThat(response -> response.body("firstName", equalTo(expectedName)));
  }
}
