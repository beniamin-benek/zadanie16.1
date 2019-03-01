import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

class Main {

    public static void main(String[] args) {

        CsvReader csvReader = new CsvReader();
        SalesCalculator salesCalculator = new SalesCalculator();
        List<Product> products = new LinkedList<>();

        try {
            products = csvReader.readFromFile();
        } catch (FileNotFoundException e) {
            System.err.println("Nie znaleziono pliku.");
        }

        for (Product product : products) {
            salesCalculator.calculateNetto(product);
            System.out.println(product);
        }

        System.out.println("Suma brutto: " + salesCalculator.calculateBruttoSum(products) + " zł.");
        System.out.println("Suma netto: " + salesCalculator.calculateNettoSum(products) + " zł.");
        System.out.println("Suma VAT: " + salesCalculator.calculateVatSum(products) + " %.");

    }

}