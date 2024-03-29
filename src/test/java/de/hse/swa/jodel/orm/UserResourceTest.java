//Class for Testing Rest Login Functionality

package de.hse.swa.jodel.orm;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class UserResourceTest
{
    //Returns all the user
    @Test
    @Order(10)
    public void GetAllUsers()
    {
        given()
                .when().get("/Users/getAllUsers")
                .then()

                .body(is("[{\"id\":1,\"password\":\"Apassword\",\"username\":\"Ausername\"},{\"id\":2,\"password\":\"Bpassword\",\"username\":\"Busername\"},{\"id\":3,\"password\":\"Dimov\",\"username\":\"Dimitar\"},{\"id\":4,\"password\":\"Sale\",\"username\":\"Moha\"}]"));
    }

    //Gets a specific user
    @Test
    @Order(20)
    public void GetOneUsers()
    {
        given()
                .when().get("/Users/getUser?userId="+1)
                .then()

                .body(is("{\"id\":1,\"password\":\"Apassword\",\"username\":\"Ausername\"}"));
    }

}
