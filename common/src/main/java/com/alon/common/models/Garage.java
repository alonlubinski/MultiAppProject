package com.alon.common.models;

public class Garage {

    private String name;
    private String address;
    private boolean open;
    private String[] Cars;

    // Constructors
    public Garage() {
    }

    public Garage(String name, String address, boolean open, String[] cars) {
        this.name = name;
        this.address = address;
        this.open = open;
        this.Cars = cars;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String[] getCars() {
        return Cars;
    }

    public void setCars(String[] cars) {
        this.Cars = cars;
    }
}
