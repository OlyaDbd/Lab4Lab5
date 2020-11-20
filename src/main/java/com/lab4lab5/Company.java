package com.lab4lab5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Company {
    private final SimpleDateFormat
            format = new SimpleDateFormat("dd.MM.yyyy");

    private String name;
    private String abbreviation;
    private Date actualDate;
    private String address;
    private Date foundationDate;
    private int employee;
    private String auditor;
    private String phoneNumber;
    private String email;
    private String branch;
    private String type;
    private String website;

    public Company (String str) throws Exception {
        String[] line = str.split(";");
        if (line.length < 12) {
            throw new Exception();
        }
        name = line[0];
        abbreviation = line[1];
        actualDate = format.parse(line[2]);
        address = line[3];
        foundationDate = format.parse(line[4]);
        employee = Integer.parseInt(line[5]);
        auditor = line[6];
        phoneNumber = line[7];
        email = line[8];
        branch = line[9];
        type = line[10];
        website = line[11];
    }



    void addStrings (String name, String abbreviation, Date actualDate, String address,
                     Date foundationDate, int employee, String auditor, String phoneNumber, String email,
                     String branch, String  type, String website) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.actualDate = actualDate;
        this.address = address;
        this.foundationDate = foundationDate;
        this.employee = employee;
        this.auditor = auditor;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.branch = branch;
        this.type = type;
        this.website = website;
    }

    //-----get-----//
    public String getAbbreviation() {
        return this.abbreviation;
    }

    public Date getFoundationDate() {
        return this.foundationDate;
    }

    public int getEmployee() {
        return this.employee;
    }

    public String getBranch() {
        return this.branch;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return employee == company.employee &&
                Objects.equals(name, company.name) &&
                Objects.equals(abbreviation, company.abbreviation) &&
                Objects.equals(actualDate, company.actualDate) &&
                Objects.equals(address, company.address) &&
                Objects.equals(foundationDate, company.foundationDate) &&
                Objects.equals(auditor, company.auditor) &&
                Objects.equals(phoneNumber, company.phoneNumber) &&
                Objects.equals(email, company.email) &&
                Objects.equals(branch, company.branch) &&
                Objects.equals(type, company.type) &&
                Objects.equals(website, company.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, abbreviation, actualDate,
                address, foundationDate, employee,
                auditor, phoneNumber, email, branch, type, website);
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + name + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", updateDate=" + actualDate +
                ", address='" + address + '\'' +
                ", foundationDate=" + foundationDate +
                ", numberOfEmployees=" + employee +
                ", auditor='" + auditor + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", industry='" + branch + '\'' +
                ", typeOfBusiness='" + type + '\'' +
                ", link='" + website + '\'' +
                '}';
    }
}
