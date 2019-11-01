package com.mymavenexperiments.paddlinglogbook.userinterface;

import java.util.Scanner;

public class TextUI {

    private Scanner scanner;

    public TextUI() {
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        printMenu();
    }

    public void printMenu() {
        System.out.println("1 per aggiungere una discesa");
        System.out.println("2 per visualizzare tutte le discese");
        System.out.println("3 per cercare tutte le discese su un fiume");
        System.out.println("4 per cercare tutte le discese in una data");
        System.out.println("5 per cercare tutte le discese in una zona\n\n");
        int choice = Integer.parseInt(this.scanner.nextLine());
        switch (choice) {
            case 1:
                //add();
                break;
            case 2:
                //showAll();
                break;
            case 3:
                //showAllOnRiver();
                break;
            case 4:
                //showAllInDate();
                break;
            case 5:
                //showAllInArea();
                break;
            default:
                break;
        }
    }
}
