import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> objectList = new ArrayList<String>();
    static ArrayList<Double> objectPriceList = new ArrayList<Double>();

    public static void main(String[] args) {
        runProgram();
    }

    static void runProgram() {
        boolean isRunning = true;
        do {
            intro();
            int input = getOption();

            switch (input) {
                case 1:
                    if (objectList.isEmpty()) {
                        System.out.println("\nDet finns inga objekt inlagda ännu.");
                        waitForInput();

                    } else {
                        printArrayLists();
                        System.out.println();
                        waitForInput();
                    }
                    break;

                case 2:
                    do {
                        System.out.println("Nytt objekt: ");
                        String name = scanner.next();
                        objectList.add(name);
                        System.out.println("Objektets pris (skriv ej in kr): ");
                        double price = scanner.nextDouble();
                        objectPriceList.add(price);

                        System.out.println();
                        System.out.print("Vill du fortsätta lägga till objekt?\n y/n: ");
                        String svar = scanner.next();

                        if (svar.equals("n")) {
                            break;
                        }
                    } while (true);
                    break;

                case 3:
                    do {
                        System.out.print("Objektnamn att ta bort: ");
                        String name = scanner.next();
                        int index = objectList.indexOf(name);
                        objectList.remove(index);
                        objectPriceList.remove(index);

                        System.out.print("Vill du fortsätta ta bort objekt?\n y/n: ");
                        String svar = scanner.next();

                        if (svar.equals("n")) {
                            break;
                        }
                    } while (true);
                    break;

                case 4:

                    if (objectList.isEmpty()) {
                        System.out.println("\nDet finns inga objekt inlagda ännu.");

                    } else {
                        System.out.println("\n\nDet dyraste föremålet är: " + objectList.get(maxValue()));
                        System.out.println("Det billigaste föremålet är: " + objectList.get(minValue()));
                        waitForInput();
                    }
                    break;

                case 5:
                    System.out.println("Stänger ner...");
                    isRunning = false;
                    break;
            }
        }
        while (isRunning);
    }

    static void intro() {
        System.out.println("\n____________________________________________\n");
        System.out.println(" - Välkommen till mitt budgeteringsprogram -\n");
        System.out.println("Vad vill du göra?\n");
        System.out.println("1 - Se samtliga varor");
        System.out.println("2 - Lägga till vara");
        System.out.println("3 - Ta bort objekt");
        System.out.println("4 - Visa dyraste och billigaste objekt");
        System.out.println("5 - Avsluta\n");
        System.out.print("Skriv ditt val här: ");
    }

    static int getOption() {
        int option = scanner.nextInt();
        return option;
    }

    static void printArrayLists() {
        for (int i = 0; i < objectList.size(); i++) {
            System.out.println();
            System.out.print(objectList.get(i) + ", Pris: " + objectPriceList.get(i) + ":-");
        }
    }

    static int maxValue() {
        double max = 0;

        for (int i = 0; i < objectPriceList.size(); i++) {
            if (objectPriceList.get(i) > max) {
                max = objectPriceList.get(i);
            }
        }
        return objectPriceList.indexOf(max);
    }

    static int minValue() {
        double min = objectPriceList.get(0);

        for (int i = 0; i < objectPriceList.size(); i++) {
            if (objectPriceList.get(i) < min) {
                min = objectPriceList.get(i);
            }
        }
        return objectPriceList.indexOf(min);
    }

    static void waitForInput() {
        String input = "";
        while (!input.equals("y")) {
            System.out.println("\nSkriv 'y' för att gå vidare");
            input = scanner.next();
        }
    }
}
