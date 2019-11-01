package com.mymavenexperiments.paddlinglogbook.application;

import java.time.LocalDate;

public class Descent implements Comparable<Descent>{

    private static int totalId = 0;
    private int id;
    private int avgDifficulty;
    private LocalDate date;
    private String area;
    private String river;
    private String stretch;

    public Descent(int avgDifficulty, LocalDate date, String area, String river, String stretch) {
        this.id = totalId + 1;
        totalId++;
        this.avgDifficulty = avgDifficulty;
        this.date = date;
        this.area = area;
        this.river = river;
        this.stretch = stretch;
    }

    @Override
    public String toString() {
        return this.id + ", " + this.avgDifficulty + ", " + this.date + ", " + this.area + ", " + this.river + ", " + this.stretch;
    }

    public int getId() {
        return id;
    }

    public int getAvgDifficulty() {
        return avgDifficulty;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getArea() {
        return area;
    }

    public String getRiver() {
        return river;
    }

    public String getStretch() {
        return stretch;
    }
    
    @Override
    public int compareTo(Descent o) {
        return this.date.compareTo(o.getDate());
    }
}
