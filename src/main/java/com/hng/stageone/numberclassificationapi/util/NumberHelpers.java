package com.hng.stageone.numberclassificationapi.util;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class NumberHelpers {
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static boolean isPerfectNumber(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    public static boolean isArmstrongNumber(int number) {
        int sum = 0;
        int temp = number;
        String numberString = String.valueOf(number);
        int power = numberString.length();
        while (temp != 0) {
            int remainder = temp % 10;
            sum += (int) Math.pow(remainder, power);
            temp /= 10;
        }
        return sum == number;
    }

    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static String numberFunFact(int number) {
        String numberAPIURL = "http://numbersapi.com/" + number + "/math";

        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(numberAPIURL, String.class);
        } catch (Exception e) {
            return "An error occurred while fetching number fact";
        }
    }

    public static List<String> getProperties(int number) {
        List<String> properties = new ArrayList<>();
        if (isArmstrongNumber(number)) {
            properties.add("armstrong");
        }
        if (number % 2 == 0) {
            properties.add("even");
        } else {
            properties.add("odd");
        }
        return properties;
    }
}













/*
public static String numberFunFact(int number) {
        String numberAPIURL = "http://numbersapi.com/" + number + "/math";

        try {
            URL url = new URL(numberAPIURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }
                reader.close();
                return response.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Failed to fetch fun fact.";
    }
 */

/*
    public int sumDigits(int number) {
        int sum = 0;
        while (number > 10) {
            sum += sumOfDigits(number);
            number = sum;
        }
        sum += number;
        return sum;
    }
 */