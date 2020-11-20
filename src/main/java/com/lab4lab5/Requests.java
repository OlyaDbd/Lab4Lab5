package com.lab4lab5;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Requests {
    List<Company> companies;

    public Requests(List<Company> companies) {
        this.companies = companies;
    }

    public List<Company> chooseByAbbreviation(String request) {
        List<Company> result = new ArrayList<>();

        for (Company company : companies) {
            if (company.getAbbreviation().equalsIgnoreCase(request)) {
                result.add(company);
            }
        }

        return result;
    }

    public List<Company> chooseByBranch(String request) {
        List<Company> result = new ArrayList<>();

        for (Company company : companies) {
            if (company.getBranch().equalsIgnoreCase(request)) {
                result.add(company);
            }
        }

        return result;
    }

    public List<Company> chooseByTypeOfBusiness(String request) {
        List<Company> result = new ArrayList<>();

        for (Company company : companies) {
            if (company.getType().equalsIgnoreCase(request)) {
                result.add(company);
            }
        }

        return result;
    }

    public List<Company> chooseByFoundationDate(Date start, Date end){
        List<Company> result = new ArrayList<>();

        for (Company company : companies) {
            if (company.getFoundationDate().after(start) &&
                    company.getFoundationDate().before(end)) {
                result.add(company);
            }
        }

        return result;
    }

    List<Company> chooseByCountOfEmployees(int start, int end){
        List<Company> result = new ArrayList<>();

        for (Company company : companies) {
            if (start <= company.getEmployee() && company.getEmployee() <= end) {
                result.add(company);
            }
        }

        return result;
    }
}
