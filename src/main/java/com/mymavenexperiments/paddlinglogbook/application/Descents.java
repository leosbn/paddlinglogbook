package com.mymavenexperiments.paddlinglogbook.application;

import java.util.List;
import java.util.ArrayList;

public class Descents {

    private List<Descent> list;

    public Descents() {
        this.list = new ArrayList<>();
    }

    public void addDescent(Descent addedDesc) {
        this.list.add(addedDesc);
    }

    public void removeDescent(Descent removedDesc) {
        this.list.remove(removedDesc);
    }

    public int countDescents() {
        return this.list.size();
    }

    public List<Descent> listAllDescents() {
        return this.list;
    }
}
