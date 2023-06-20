package Utility;

import de.taimos.totp.TOTP;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;



/**
 * @author Nahid
 */
public class RateCollection {


    public void getRate() throws Exception {
        String email = BaseData.BaseEmail();
        String password = BaseData.BasePassword();
        String code=BaseData.BaseOtp();
        String secretKey="V4TMHG53QFYHQNPAH3C75VOVHM";

        String fromCurrency="EUR";
        String[] toCurrency={"USD","EUR","GBP","JPY","CNY"};

        //CSRF API Call
        RestAssured.baseURI="https://api.dev.auws.cloud";
        Response response=given().headers(
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().get("/v2/auth/csrf")
                .then().assertThat().statusCode(200).body("status",equalTo ("success"))
                .extract().response();
          String bearerToken=response.getBody().path("data.csrfToken.token");

        //Login API Call

        RestAssured.baseURI = "https://api.dev.auws.cloud";
        Response response2=given().headers(
                        "Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept", ContentType.JSON)
                .body("{\r\n"
                        + "    \"email\": \""+email+"\",\r\n"
                        + "    \"password\": \""+password+"\",\r\n"
                        + "    \"brand\": \"ClubSwan\"\r\n"
                        + "}")
                .when().post("/v2/auth/login")
                .then().extract().response();
        String confirmToken=response2.getBody().path("data.confirmToken.token");


        //Confirmation 2FA
        //String code=getTOTPCode(secretKey);

        RestAssured.baseURI = "https://api.dev.auws.cloud";
        Response response3=given().headers(
                        "Authorization",
                        "Bearer " + confirmToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept", ContentType.JSON)
                .body("{\r\n"
                        + "    \"secretCode\": \""+code+"\"\r\n"
                        + "}")
                .when().post("/v2/auth/device/confirm")
                .then().extract().response();
        String accessToken=response3.getBody().path("data.accessToken.token");


        //Get conversion rate
        RestAssured.baseURI="https://api.dev.auws.cloud";
        String baseUrl = "/v1/fx/rate/";

        for (int i=0;i<toCurrency.length;i++) {
            String encodedFromCurrency = URLEncoder.encode(fromCurrency, StandardCharsets.UTF_8.toString());
            String encodedToCurrency = URLEncoder.encode(toCurrency[i], StandardCharsets.UTF_8.toString());
            String finalUrl = baseUrl + "" + encodedFromCurrency + "/" + encodedToCurrency;
            Response response4 = given().headers(
                            "Authorization",
                            "Bearer " + accessToken,
                            "Content-Type",
                            ContentType.JSON,
                            "Accept", ContentType.JSON)
                    .when().get(finalUrl)
                    .then().extract().response();
            String rate = response4.getBody().path("data.rate").toString();
            Double conversionRate = Double.valueOf(rate);
            System.out.println("Convertion Rate " + fromCurrency + " To " + toCurrency[i] + " : " + conversionRate );
        }

    }

    private static String getTOTPCode(String secretKey) {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);
        String hexKey = Hex.encodeHexString(bytes);
        String x= TOTP.getOTP(hexKey);
        //System.out.println("Totp: "+ TOTP.getOTP(hexKey));
        return TOTP.getOTP(hexKey);
    }
}
