package com.lab4lab5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Company> companies = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("Companies.txt"))) {
            while (scanner.hasNext()) {
                Company company = new Company(scanner.nextLine());
                companies.add(company);
            }
            searchingByRequest(companies);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    static void searchingByRequest(List<Company> companies) {
        System.out.println("Enter the number (0-5)\n" +
                "0 - exit;\n" +
                "1 - search a company by abbreviation;\n" +
                "2 - search a company by branch;\n" +
                "3 - search a company by type of business;\n" +
                "4 - search a company by foundation date;\n" +
                "5 - search a company by number of employees.\n");

        try (Scanner scanner = new Scanner(System.in)) {
            FileWriter logFile =
                    new FileWriter(new File("logfile.txt"), true);
            FileWriter outputFile =
                    new FileWriter(new File("OutputFile.txt"));
            List<Company> result = new ArrayList<>();
            String category;
            Requests manager = new Requests(companies);
            while (!(category = scanner.next()).equals("0")) {
                String request = "";
                switch (category) {
                    case "1" -> {
                        System.out.println("Enter abbreviation:");
                        request = scanner.next();
                        result = manager.chooseByAbbreviation(request);
                    }
                    case "2" -> {
                        System.out.println("Enter branch:");
                        request = scanner.next();
                        result = manager.chooseByBranch(request);
                    }
                    case "3" -> {
                        System.out.println("Enter type of business:");
                        request = scanner.next();
                        result = manager.chooseByTypeOfBusiness(request);
                    }
                    case "4" -> {
                        System.out.println("Enter foundation date:");
                        Date start = new SimpleDateFormat(
                                "dd.MM.yyyy").parse(scanner.next());
                        Date end = new SimpleDateFormat(
                                "dd.MM.yyyy").parse(scanner.next());
                        request += start.toString() + end.toString();
                        result = manager.chooseByFoundationDate(start, end);
                    }
                    case "5" -> {
                        System.out.println("Enter number of employees:");
                        request = scanner.nextLine();
                        int numFrom = Integer.parseInt(scanner.next());
                        int numTo = Integer.parseInt(scanner.next());
                        request += numFrom + numTo;
                        result = manager.chooseByCountOfEmployees(numFrom, numTo);
                    }

                }
                logWriting(logFile, request, result.size());
                fileWriting(outputFile, result);
            }
            logFile.close();
            outputFile.close();
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }


    static void logWriting(FileWriter logFile, String request,
                           int amountFound) throws IOException {
        SimpleDateFormat formatNow = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date now = new Date();
        logFile.write("Date and time of running: " + formatNow.format(now) + "\n");
        logFile.write("Request: " + request + "\n");
        logFile.write("Amount of matching notes: " + amountFound + "\n");
    }


    static void fileWriting(FileWriter outputFile,
                            List<Company> inf) throws IOException {
        for (Company company : inf) {
            outputFile.append(company.toString());
            outputFile.append(",");
            outputFile.append(System.lineSeparator());
        }
    }

}
