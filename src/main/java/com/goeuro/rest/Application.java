package com.goeuro.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

/**
 * This is the main entry class to this Project/Application.
 * It is a stand alone java class with a main method {@link #main(String[])}
 * 
 * @author Simon Njenga
 * @since 0.1
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);
    private static final String URL = "http://api.goeuro.com/api/v2/position/suggest/en/";

    /**
     * Entry point to the Application.
     * 
     * @param args Command line arguments
     * @throws IOException If starting the application fails
     */
    public static void main(String args[]) throws IOException {
        if (args == null || args.length == 0 || args[0] == null || args[0].isEmpty()) {
            LOG.info("City name MUST be specified!");
            throw new IllegalArgumentException("City name MUST be specified!");				       
        }
        String inputString = "";

        if (args.length == 1) {
            // used for cities with one string e.g "Sydney", "Berlin", "Rome"
            inputString = args[0].trim();
        } else {
            // used for cities with more than one string e.g "Sao Tome", "Tel Aviv", "Rio de Janeiro"
            for (int i = 0; i < args.length; i++) {
                inputString = inputString + (args[i] != null ? args[i] : "") + " ";
            }
        }
        SpringApplication.run(Application.class, inputString);    	  	
    }

    @Override
    public void run(String... strings) throws Exception {
        if (this.areWeOnline()) {
            LOG.info(strings[0]);
            RestTemplate restTemplate = new RestTemplate();

            List<City> cities = Arrays.asList(
                restTemplate.getForObject(URL.concat(strings[0]), City[].class));

            this.writeToCSVfile(cities);
        } else {
            LOG.info("No Internet connection, Please provide a connection!");
            throw new IllegalStateException("There is No Internet connection, Please provide a connection!");
        }
    }
    
    /**
     * Writes the list of JSON data to the CSV file
     * 
     * @param cities the list of {@link City} to use
     * @throws IOException If there is a problem
     */
    private void writeToCSVfile (List<City> cities) throws IOException {
        // This is used to write bytes to the file
        Writer writer = null;

        try {
            // This is used to output the file to be returned
            File outputFile = new File("GoEuroTest.csv");

            // uses "ISO_8859_1" Charset to enable the writing of "umlauts" found in Germanic languages
            writer = new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.ISO_8859_1);

            if (cities.isEmpty()) {
                writer.write("THE ENDPOINT FOUND NO MATCHING RESULTS FOR THE SPECIFIED CITY!");
                LOG.info("CSV file successfully created; No matching results found for the specified city!");
            } else {
                // DO NOT remove the space before ID; It fixes Ms Excel error in CSV files (CSV excel SYLK file)
                writer.write("  ID, NAME, TYPE, LATITUDE, LONGITUDE \n");

                StringBuffer sb = new StringBuffer();

                //Write the city list to the CSV file
                for (int i = 0; i < cities.size(); i++) {
                    sb.append(cities.get(i).get_id().toString()).append(", ")
                        .append(cities.get(i).getName()).append(", ")
                        .append(cities.get(i).getType()).append(", ")
                        .append(cities.get(i).getGeo_position().getLatitude().toString()).append( ", ")
                        .append(cities.get(i).getGeo_position().getLongitude().toString()).append("\n");
                }
                writer.write(sb.toString());
                LOG.info("CSV file was created successfully!");
            }			
        } catch (IOException e) {
            LOG.info("Error !" + e.getMessage());
            e.printStackTrace();
        } finally {
            // This Writer should ideally be closed by: org.apache.commons.io.IOUtils#closeQuietly(Writer)
            writer.close();
        }
    }
    
    /**
     * Are we online? Do we have an Internet connection?
     * @return TRUE if we're online
     */
    private boolean areWeOnline() {
        boolean online = true;
        try {
            // test online connection with google.com worldwide home page
            new URL("http://www.google.com/").getContent();
        } catch (IOException ex) {
            online = false;
        }
        return online;
    }
}