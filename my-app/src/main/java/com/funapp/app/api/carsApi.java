package com.funapp.app.api;

import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class carsApi {
    private static final String APIKEY  = ""; //Add own APIKey to access
    private static final String APIHOST = ""; //Add API Host to access

    public String getRandomCar() throws IOException {

        URL url = new URL("https://car-data.p.rapidapi.com/cars/types");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-RapidAPI-Key", APIKEY);
        connection.setRequestProperty("X-RapidAPI-Host", APIHOST);
        connection.setRequestProperty("accept", "application/json");
        InputStream responseStream = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseStream);

        return cleanData(root);
    }


    private String cleanData(JsonNode root) {
        Map<Integer,String> cleanedMap = new HashMap<Integer,String>();
        Random rand = new Random();

        int random = rand.nextInt(8);

        for (int i = 0; i < root.size(); i++) {
            cleanedMap.put(i, root.get(i).toString().replaceAll("\"", ""));
        }
        return cleanedMap.get(random);
    }
}