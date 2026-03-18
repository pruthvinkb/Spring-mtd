package com.example.demo;

import java.util.List;

public class StudentResults {
    private String name;
    private List<Integer> marks;
    private int total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int calculateTotal() {
        this.total = marks.stream().mapToInt(Integer::intValue).sum();
        return this.total;
    }
}
