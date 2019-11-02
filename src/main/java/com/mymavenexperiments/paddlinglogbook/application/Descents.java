package com.mymavenexperiments.paddlinglogbook.application;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Descents implements Serializable {

    private List<Descent> list;
    private final String FILENAME = "paddlinglogbook-data.dat";
    private final String PATH = System.getProperty("user.home");
    private File file = new File(PATH + File.separator + FILENAME);

    /**
     * the class manages creation and serialization of information on a local
     * file it checks for previous data in the file and loads it to the main
     * container at startup it saves the data at shutdown
     */
    public Descents() {
        this.list = new ArrayList<>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
            List<Descent> contents = (List<Descent>) input.readObject();
            this.list.addAll(contents);
            input.close();
        } catch (IOException e) {
            System.out.println("Sorry " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry " + e);
        } catch (ClassCastException e) {
            System.out.println("Sorry " + e);
        }
    }

    /**
     * the method adds a descent to the list
     *
     * @param addedDesc
     */
    public void addDescent(Descent addedDesc) {
        this.list.add(addedDesc);
    }

    /**
     * this method lists all the contents
     *
     * @return list of descents
     */
    public List<Descent> listAllDescents() {
        return this.list;
    }

    /**
     * the method shows all descents on a given river
     *
     * @param river
     * @return
     */
    public List<Descent> showAllOnRiver(String river) {
        List<Descent> lista = new ArrayList<>();
        for (Descent each : this.list) {
            if (each.getRiver().equalsIgnoreCase(river)) {
                lista.add(each);
            }
        }
        return lista;
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
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(this.list);
            output.close();
        } catch (IOException e) {
            System.out.println("Sorry " + e);
        }
    }
}
