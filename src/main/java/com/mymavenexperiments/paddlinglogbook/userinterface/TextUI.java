package com.mymavenexperiments.paddlinglogbook.userinterface;

import com.mymavenexperiments.paddlinglogbook.application.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class TextUI {

    private Scanner scanner;
    private Descents descents;

    public TextUI() {
        this.scanner = new Scanner(System.in);
        this.descents = new Descents();
    }

    public void run() {
        printMenu();
    }

    /**
     * this prints the main menu of the program
     */
    public void printMenu() {
        MENULOOP:
        while (true) {
            System.out.println("1 per aggiungere una discesa");
            System.out.println("2 per visualizzare tutte le discese");
            System.out.println("3 per cercare tutte le discese su un fiume");
            System.out.println("4 per cercare tutte le discese in una data");
            System.out.println("5 per salvare e chiudere");
            try {
                int choice = Integer.parseInt(this.scanner.nextLine());
                switch (choice) {
                    case 1:
                        add();
                        break;
                    case 2:
                        showAll();
                        break;
                    case 3:
                        showAllOnRiver();
                        break;
                    case 4:
                        showAllInDate();
                        break;
                    case 5:
                        saveAndClose();
                        break MENULOOP;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                printMenu();
            }
        }
    }

    /**
     * this method collects the data to be added as a new descent
     */
    public void add() {
        System.out.println("Difficoltà della discesa:");
        int avgDiff = Integer.parseInt(this.scanner.nextLine());
        System.out.println("Data: anno");
        int year = Integer.parseInt(this.scanner.nextLine());
        System.out.println("Data: mese");
        int month = Integer.parseInt(this.scanner.nextLine());
        System.out.println("Data: giorno");
        int day = Integer.parseInt(this.scanner.nextLine());
        LocalDate date = LocalDate.of(year, month, day);
        System.out.println("Area:");
        String area = this.scanner.nextLine();
        System.out.println("River:");
        String river = this.scanner.nextLine();
        System.out.println("Stretch:");
        String stretch = this.scanner.nextLine();
        this.descents.addDescent(new Descent(avgDiff, date, area, river, stretch));
    }

    /**
     * this method shows all the descents
     */
    public void showAll() {
        for (Descent desc : this.descents.listAllDescents()) {
            System.out.println(desc);
        }
    }

    /**
     * this method shows all the descents on a given river
     */
    public void showAllOnRiver() {
        System.out.println("Quale fiume?");
        String river = this.scanner.nextLine();
        System.out.println(this.descents.showAllOnRiver(river));
    }

    /**
     * this method shows all the descents on a given day
     */
    public void showAllInDate() {
        System.out.println("Data: anno");
        int year = Integer.parseInt(this.scanner.nextLine());
        System.out.println("Data: mese");
        int month = Integer.parseInt(this.scanner.nextLine());
        System.out.println("Data: giorno");
        int day = Integer.parseInt(this.scanner.nextLine());
        LocalDate date = LocalDate.of(year, month, day);
        System.out.println(this.descents.showAllInDate(date));
    }

    /**
     * this method saves everything, then the main menu shuts the application
     * down
     */
    public void saveAndClose() {
        this.descents.closeAndSave();
    }
}
