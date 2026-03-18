package com.example.demo.dto.response;

public class StudentResponse {
    private String name;
    private int rollnumber;
    private int total;
    private double percentage;
    private String result;

    public StudentResponse(String name, int rollnumber, int total, double percentage, String result) {
        this.name = name;
        this.rollnumber = rollnumber;
        this.total = total;
        this.percentage = percentage;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(int rollnumber) {
        this.rollnumber = rollnumber;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    
}
