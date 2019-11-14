package com.mymavenexperiments.paddlinglogbook.application;

import java.io.Serializable;
import java.time.LocalDate;

public class Descent implements Comparable<Descent>, Serializable {

    private int avgDifficulty;
    private LocalDate date;
    private String area;
    private String river;
    private String stretch;

    public Descent(int avgDifficulty, LocalDate date, String area, String river, String stretch) {
        this.avgDifficulty = avgDifficulty;
        this.date = date;
        this.area = area;
        this.river = river;
        this.stretch = stretch;
    }

    @Override
    public String toString() {
        return this.avgDifficulty + ", " + this.date + ", " + this.area + ", " + this.river + ", " + this.stretch;
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
