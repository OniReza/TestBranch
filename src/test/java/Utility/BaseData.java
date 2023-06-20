package Utility;

import de.taimos.totp.TOTP;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import org.apache.poi.ss.formula.functions.T;

public class BaseData {
    public static String BaseUrlMain() {
        String PortalTst = BasePortals.portalsTST();
        String URL = PortalTst;
        return URL;
    }

    public static String BasePopUpUrl() {
        String PortalDev = BasePortals.portalsDEV();
        String PURL = PortalDev;
        return PURL;
    }

    public static String BaseEmail() throws Exception {
        String Email = BaseCredentials.BaseEmailList();
        return Email;
    }

    public static String BasePassword() throws Exception {
        String Password = BaseCredentials.BasePassword();
        return Password;
    }

    public static String BaseOtp() throws Exception {
        String secretKey = BaseCredentials.BaseOTPList();
        String code = getTOTPCode(secretKey);
        return code;


    }

    private static String getTOTPCode(String secretKey) throws InterruptedException {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);
        String hexKey = Hex.encodeHexString(bytes);
//        System.out.println("2FA Code: " + TOTP.getOTP(hexKey));
        return TOTP.getOTP(hexKey);
    }

//    Apexx Card number
    public static String cardNumber() {
        String number = "5200000000001005";
//        String number = "4456530000001005";
        return number;
    }

    public static String cardMonth() {
        String month = "11";
        return month;
    }

    public static String cardYear() {
        String year = "31";
        return year;
    }

    public static String cardCvv() {
        String cvv = "003";
        return cvv;
    }

//    Stripe Card Number
    public static String stripeCardNumber() {
        String number = "5555555555554444";
        return number;
    }

    public static String stripeCardExpiry() {
        String date = "1130";
        return date;
    }

}
