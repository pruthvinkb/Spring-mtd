package com.example.Demo.dto.responce;

public class StudentResponce {
    private Long id;
    private String name;
    private String registerationNumber;
    
    public StudentResponce(Long id, String name, String registerationNumber) {
        this.id = id;
        this.name = name;
        this.registerationNumber = registerationNumber;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRegisterationNumber() {
        return registerationNumber;
    }
    public void setRegisterationNumber(String registerationNumber) {
        this.registerationNumber = registerationNumber;
    }
    
}
