package com.mymavenexperiments.paddlinglogbook.application;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class Descents implements Serializable {

    private List<Descent> list;
    private Datab db;

    /**
     * the class manages creation and serialization of information on a local
     * file it checks for previous data in the file and loads it to the main
     * container at startup it saves the data at shutdown
     */
    public Descents() {
        this.list = new ArrayList<>();
        this.db = new Datab();
        this.db.connect();
    }

    /**
     * the method adds a descent to the list
     *
     * @param addedDesc
     */
    public void addDescent(Descent addedDesc) {
        this.list.add(addedDesc);
        this.db.addToTable(addedDesc);
    }

    /**
     * this method lists all the contents
     *
     * @return list of descents
     */
    public List<Descent> listAllDescents() {
        //return this.list;
        return this.db.listAll();
    }

    /**
     * the method shows all descents on a given river
     *
     * @param river
     * @return
     */
    public List<Descent> showAllOnRiver(String river) {
        List<Descent> lista = new ArrayList<>();
        return this.db.listOnlyRiver(river);
    }

    /**
     * the method shows all descents on a given day
     *
     * @param river
     * @return
     */
    public List<Descent> showAllInDate(LocalDate date) {
        List<Descent> lista = new ArrayList<>();
        for (Descent each : this.list) {
            if (each.getDate().equals(date)) {
                lista.add(each);
            }
        }
        return lista;
    }

    /**
     * the method serializes data to a file
     */
    public void closeAndSave() {
        /*
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(this.list);
            output.close();
        } catch (IOException e) {
            System.out.println("Sorry " + e);
        }
         */
    }
}
