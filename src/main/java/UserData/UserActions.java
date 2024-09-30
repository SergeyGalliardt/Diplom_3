package UserData;

import io.qameta.allure.Step;

import static UserData.Constants.*;
import static io.restassured.RestAssured.given;


public class UserActions {
    @Step("Создание пользователя")
    public void userCreate(User user) {
        given()
                .spec(Preset.spec())
                .body(user)
                .when()
                .post(USER_CREATE)
                .then()
                .statusCode(200);
    }

    @Step("Получение токена пользователя")
    public String getAccessToken(User user) {
        return given()
                .spec(Preset.spec())
                .body(user)
                .when()
                .post(USER_LOGIN)
                .then()
                .extract()
                .path("accessToken")
                .toString();
    }

    @Step("Удаление пользователя")
    public void userDelete(String accessToken) {
        given()
                .spec(Preset.spec())
                .headers("authorization", accessToken)
                .when()
                .delete(USER_EDIT)
                .then()
                .statusCode(202);
    }
}

