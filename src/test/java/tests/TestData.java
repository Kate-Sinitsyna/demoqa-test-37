package tests;

import com.github.javafaker.Faker;

import java.time.Year;

public class TestData {

    Faker faker = new Faker();

     public String firstName = faker.name().firstName(),
        lastName = faker.name().lastName(),
        email = faker.internet().emailAddress(),
        currentAddress = faker.address().streetAddress(),
        userNumber = faker.phoneNumber().subscriberNumber(10),
        gender = faker.options().option("Male", "Female","Other"),
        day =  String.format("%02d", faker.number().numberBetween(1, 28)),
        month = faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"),
        year = String.valueOf(faker.number().numberBetween(1900, Year.now().getValue() - 17)),
        subject = faker.options().option("Math", "Physics", "Chemistry","Arts", "Accounting", "Social Studies"),
        hobbies = faker.options().option("Sports", "Reading","Music"),
        picture = faker.options().option("example.jpeg","example-2.png", "example-3.png"),
        state = faker.options().option("NCR", "Uttar Pradesh","Haryana", "Rajasthan"),
        city = selectCity(state);

     public String selectCity(String state){
        switch(state){
            case "NCR":
                city = faker.options().option("Delhi", "Gurgaon","Noida");
                break;
            case "Uttar Pradesh":
                city = faker.options().option("Agra", "Lucknow","Merrut");
                break;
            case "Haryana":
                city = faker.options().option("Karnal", "Panipat");
                break;
            case "Rajasthan":
                city = faker.options().option("Jaipur", "Jaiselmer");
                break;
        }

         return city;
     }
}
