package com.bridgelabz.opencsvandgson;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
class OpenCSVToGson {
    private static final String FILE_PATH = "./sample.csv";
    private static final String JSON_FILE_PATH = "./sample.json";

    public static void main(String[] args){
        try {
            Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
            CsvToBeanBuilder<CSVUser> csvToBean = new CsvToBeanBuilder<>(reader);
            csvToBean.withType(CSVUser.class);
            csvToBean.withIgnoreLeadingWhiteSpace(true).build();

            List<CSVUser> csvUsers = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);
            FileWriter writer = new FileWriter(JSON_FILE_PATH);
            writer.write(json);
            writer.close();
            BufferedReader br = new BufferedReader(new FileReader(JSON_FILE_PATH));
            CSVUser[] usrObj = gson.fromJson(br, CSVUser[].class);
            List<CSVUser> csvUserList = Arrays.asList(usrObj);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
