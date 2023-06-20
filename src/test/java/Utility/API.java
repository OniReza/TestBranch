package Utility;

import de.taimos.totp.TOTP;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static Utility.BaseCredentials.testEnv;
import static Utility.UserProfile.cardLoad.clRate;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class API {

    public static class CurrencyExchangeRate {
        public static double ToUSD = 1;
        public static double ToEuro = 1;
        public static double ToGBP = 1;
        public static double ToJPY = 1;
        public static double ToCNY = 1;
        public static double ToPHP = 1;
        public static void getRate() throws Exception {
            String email = BaseData.BaseEmail();
            String password = BaseData.BasePassword();
            String code = BaseData.BaseOtp();
            int statusCode;
            String accessToken = "";
            String url = "";
            if (testEnv().trim().equals("tst")) {
                url = "https://api.tst.auws.cloud";
            } else if (testEnv().trim().equals("dev")) {
                url = "https://api.dev.auws.cloud";
            } else {
                System.out.println("Please check Environment name in config.properties file");
            }
            String fromCurrency = UserProfile.planCurrency;
            String[] toCurrency = {"USD", "EUR", "GBP", "JPY", "CNY", "PHP"};
            double[] trate = new double[toCurrency.length];


            //CSRF API Call
            RestAssured.baseURI = url;
            Response response = given().headers(
                            "Content-Type",
                            ContentType.JSON,
                            "Accept",
                            ContentType.JSON)
                    .when().get("/v2/auth/csrf")
                    .then().assertThat().statusCode(200).body("status", equalTo("success"))
                    .extract().response();
            String bearerToken = response.getBody().path("data.csrfToken.token");

            //Login API Call
            RestAssured.baseURI = url;
            Response response2 = given().headers(
                            "Authorization",
                            "Bearer " + bearerToken,
                            "Content-Type",
                            ContentType.JSON,
                            "Accept", ContentType.JSON)
                    .body("{\r\n"
                            + "    \"email\": \"" + email + "\",\r\n"
                            + "    \"password\": \"" + password + "\",\r\n"
                            + "    \"brand\": \"ClubSwan\"\r\n"
                            + "}")
                    .when().post("/v2/auth/login")
                    .then().extract().response();
            String confirmToken = response2.getBody().path("data.confirmToken.token");
            System.out.println("Status Code after entering Password:" + response2.getStatusCode());

            //Confirmation 2FA
            int count = 0;
            do {
                Thread.sleep(2000);
                RestAssured.baseURI = url;
                Response response3 = given().headers(
                                "Authorization",
                                "Bearer " + confirmToken,
                                "Content-Type",
                                ContentType.JSON,
                                "Accept", ContentType.JSON)
                        .body("{\r\n"
                                + "    \"secretCode\": \"" + code + "\"\r\n"
                                + "}")
                        .when().post("/v2/auth/device/confirm")
                        .then().extract().response();

                accessToken = response3.getBody().path("data.accessToken.token");
                response3.getStatusCode();
                statusCode = response3.getStatusCode();
                System.out.println("Status code after entering otp: " + statusCode);
                count++;
                System.out.println("Request count to fetch rate: " + count);
            } while (statusCode != 200 && count < 3);
            //Get conversion rate
            RestAssured.baseURI = url;
            String baseUrl = "/v1/fx/rate/";
            for (int i = 0; i < toCurrency.length; i++) {
                if (fromCurrency.equals(toCurrency[i])) {
                    trate[i] = 1.00;
                } else {
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
                    trate[i] = conversionRate;
                }
                System.out.println(fromCurrency + " To " + toCurrency[i] + " : " + trate[i]);
                ToUSD = trate[0];
                ToEuro = trate[1];
                ToGBP = trate[2];
                ToJPY = trate[3];
                ToCNY = trate[4];
                ToPHP = trate[5];
            }
        }
    }
}
