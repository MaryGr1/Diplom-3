package steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.pages.User;

import static io.restassured.RestAssured.given;

public class UserSteps {

    private final RequestSpecification reqSpec;

    public UserSteps(RequestSpecification reqSpec) {
        this.reqSpec = reqSpec;
    }

    @Step("Send POST request to /api/auth/register")

    public ValidatableResponse createUser (User user){
        return given()
                .spec(reqSpec)
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post("/api/auth/register")
                .then();
    }


    @Step("Send POST request to /api/auth/login")

    public ValidatableResponse loginUser(User user){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post("/api/auth/login")
                .then();
    }


    @Step("Send DELETE request to /api/auth/user")
    public void deleteUser(String token) {
        given()
                .spec(reqSpec)
                .header("Authorization", token)
                .delete("/api/auth/user");
    }
}
