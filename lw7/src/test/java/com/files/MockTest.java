package com.files;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class MockTest {

  private static final String BASE_PATH = "http://localhost:2345";
  private static final String PATH = "/api/test/";

  private final RequestSpecification requestSpecification = new RequestSpecBuilder()
          .setBaseUri(BASE_PATH)
          .setAccept(ContentType.JSON)
          .setContentType(ContentType.JSON)
          .build();

  void getById(Integer id) {
    given()
            .spec(requestSpecification)
            .when()
            .get(PATH + id)
            .then()
            .body("code", equalTo(id))
            .extract().body();
  }

  void getByIdBadRequest(Integer id) {
    given()
            .spec(requestSpecification)
            .when()
            .get(PATH + id)
            .then()
            .assertThat()
            .statusCode(HttpStatus.SC_BAD_REQUEST);
  }

  @Test
  void getById_ReturnsById1() {
    Integer id = 1;
    getById(id);
    System.out.println("Check by id: " + id);
  }

  @Test
  void getById_ReturnsBadRequest() {
    Integer id = 42352;
    getByIdBadRequest(id);
    System.out.println("Bad Request by id: " + id);
  }
}
