package Utility;

import com.github.javafaker.Faker;
import java.util.Random;

public class Random_data {

    public static Faker fake = new Faker();

    public static String firstName() {
        String fName = fake.name().firstName().replaceAll("'", "");
        return fName;
    }

    public static String lastName() {
        String lName = fake.name().lastName().replaceAll("'", "");
        return lName;
    }

    public static String fullName() {
        String fName = fake.name().fullName().replaceAll("[^a-zA-Z]", " ");
        return fName;
    }

    public static String usCity() {
        Random random = new Random();
        String[] cityList = {"Jacksonville", "California", "Illinois", "Dallas", "Charlotte", "Nashville", "Albuquerque", "Kansas City", "Omaha", "Miami"};
        int randomIndex = random.nextInt(cityList.length); // generates a random index between 0 and 9
        String city = cityList[randomIndex];
        return city;
    }

    public static String businessName() {
        String bName = fake.company().industry().replaceAll("[^a-zA-Z]", " ") + " Business";
        return bName;
    }

    public static String bankName() {
        String bName = fake.company().industry().replaceAll("[^a-zA-Z]", " ") + " Bank";
        return bName;
    }

    public static String businessRegNum() {
        int Num = fake.number().numberBetween(100000, 999999);
        String bRegNum = Integer.toString(Num);
        return bRegNum;
    }

    public static String address() {
        String streetAddress = fake.address().streetAddress();
        return streetAddress;
    }

    public static String phoneNumber() {
        int code = fake.number().numberBetween(22222222, 99999999);
        String postcode = "15" + code;
        return postcode;
    }

    public static String postCode() {
        int code = fake.number().numberBetween(10000, 99999);
        String postcode = Integer.toString(code);
        return postcode;
    }

    public static String email() {
        String email = firstName().toLowerCase().trim() + "@mailinator.com";
        return email;
    }

    public static String bankAccNum() {
        int number = fake.number().numberBetween(100000000, 999999999);
        String accNum = Integer.toString(number);
        return accNum;
    }

    public static String sortCode() {
        int number = fake.number().numberBetween(222222, 999999);
        String accNum = Integer.toString(number);
        return accNum;
    }

    public static String ssnNumber() {
        int ssnNum = fake.number().numberBetween(555555555, 888888888);
        String accNum = Integer.toString(ssnNum);
        return accNum;
    }

    public static int monthNumber(String monthName){
        String[] monthNames= {"January","February","March","April","May","June","July","August","September","October","November","December"};
        int monthNum;
        for(int i=0;i<=monthNames.length;i++) {
            if(monthNames[i].contains(monthName)) {
                monthNum=i+1;
                return monthNum;
            }
        }
        return 15;
    }


}
