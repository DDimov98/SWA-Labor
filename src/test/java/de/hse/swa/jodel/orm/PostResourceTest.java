//Class for Testing Rest Post Functionality

package de.hse.swa.jodel.orm;

import de.hse.swa.jodel.orm.model.Post;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PostResourceTest
{
    //Gets every post independent of Position
    @Test
    @Order(10)
    public void GetAllPosts()
    {
        given()
                .when().get("/Post/getAllPosts")
                .then()

                .body(is("[{\"authorId\":1,\"id\":1,\"latitude\":42.0,\"longitude\":25345.0,\"postedat\":\"2022-01-01T00:00:00Z[UTC]\",\"text\":\"First Post\"},{\"authorId\":2,\"id\":2,\"latitude\":42042.0,\"longitude\":6969.0,\"postedat\":\"2022-01-01T00:00:00Z[UTC]\",\"text\":\"Second Post\"},{\"authorId\":1,\"id\":3,\"latitude\":42.0,\"longitude\":25345.0,\"postedat\":\"2022-01-01T00:00:00Z[UTC]\",\"text\":\"Third Post\"}]"));

    }


    //Depending on position
    @Test
    @Order(20)
    public void GetPosts()
    {
        given()
                .when().get("/Post/getPosts?lat=42&lon=25345")
                .then()
                .body(is("[{\"authorId\":1,\"id\":1,\"latitude\":42.0,\"longitude\":25345.0,\"postedat\":\"2022-01-01T00:00:00Z[UTC]\",\"text\":\"First Post\"},{\"authorId\":1,\"id\":3,\"latitude\":42.0,\"longitude\":25345.0,\"postedat\":\"2022-01-01T00:00:00Z[UTC]\",\"text\":\"Third Post\"}]"));
    }

   /* @Test
    @Order(30)
    public void CreatePost()
    {
        Long testid = 1L;
        given()
                .when().post("/Post/createPost?text=junge&lon=20&lat=20&authorId="+ testid)
                .then()
                .body(is("{\"authorId\":1,\"id\":11,\"latitude\":20.0,\"longitude\":20.0,\"postedat\":\"2021-06-15T23:03:41.177Z[UTC]\",\"text\":\"junge\"}"));
    }
*/

}
