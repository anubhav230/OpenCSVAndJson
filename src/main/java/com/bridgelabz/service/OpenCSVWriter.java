package com.bridgelabz.service;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.model.CSVUser;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class OpenCSVWriter {
    private static final String FILE_PATH = "./sample.csv";

    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {

        try (
                Writer writer = Files.newBufferedWriter(Paths.get(FILE_PATH));
        ) {
            StatefulBeanToCsv<CSVUser> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            List<CSVUser> CSVUsers = new ArrayList<>();
            CSVUsers.add(new CSVUser("Anubhav Singh", "anubhavsingh@230", "2345678901", "india"));
            CSVUsers.add(new CSVUser("Ankit", "ankit@gmail.com", "555555555", "india"));
            CSVUsers.add(new CSVUser("neeru", "neeru@gmail.com", "8888888888", "india"));

            beanToCsv.write(CSVUsers);

        }
    }
}

