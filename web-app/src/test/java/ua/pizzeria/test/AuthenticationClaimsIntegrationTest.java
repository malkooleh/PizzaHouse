package ua.pizzeria.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.test.context.junit4.SpringRunner;
import ua.pizzeria.AppStarter;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

//Before running this test make sure authorization server is running   
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppStarter.class, webEnvironment = WebEnvironment.RANDOM_PORT)
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class AuthenticationClaimsIntegrationTest {

    @Autowired
    private JwtTokenStore tokenStore;

    @Test
    public void whenTokenDontContainIssuer_thenSuccess() {
        final String tokenValue = obtainAccessToken("fooClientIdPassword", "john", "123");
        final OAuth2Authentication auth = tokenStore.readAuthentication(tokenValue);

        log.info("TokenValue : {}", tokenValue);
        log.info("OAuth2Authentication : {}", auth);
        assertTrue(auth.isAuthenticated());
        log.info("Details of auth : {}", auth.getDetails());

        Map<String, Object> details = (Map<String, Object>) auth.getDetails();
        assertTrue(details.containsKey("organization"));
        log.info(String.valueOf(details.get("organization")));
    }

    private String obtainAccessToken(String clientId, String username, String password) {
        final Map<String, String> params = new HashMap<>();
        params.put("grant_type", "password");
        params.put("client_id", clientId);
        params.put("username", username);
        params.put("password", password);
        final Response response = RestAssured.given().auth().preemptive()
                .basic(clientId, "secret")
                .and()
                .with()
                .params(params).when().post("http://localhost:8081/oauth-server/oauth/token");
        return response.jsonPath().getString("access_token");
    }

}
