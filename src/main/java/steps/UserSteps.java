package steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.example.pages.User;

import static io.restassured.RestAssured.given;

public class UserSteps {


    @Step("Send DELETE request to /api/auth/user")
    public ValidatableResponse userDelete(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .delete("/api/auth/user")
                .then();
    }
    @Step("Delete user data after authorization")
    public ValidatableResponse userDeleteAfterLogin(User user) {
        ValidatableResponse loginResponse = loginUser(user);
        String accessToken = loginResponse.extract().path("accessToken");

        if (accessToken == null) {
            throw new IllegalStateException("Authorization failed, no access token received. Response: " +
                    loginResponse.extract().asString());
        }

        return userDelete(accessToken);
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
}
