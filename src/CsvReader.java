import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class CsvReader {

    List<Product> readFromFile() throws FileNotFoundException {

        File file = new File("products.csv");
        Scanner scanner = new Scanner(file);
        String product;
        List<Product> products = new LinkedList<>();

        while (scanner.hasNextLine()) {
            product = scanner.nextLine();
            String[] productFields = product.split(";");
            try {
                products.add(new Product(productFields[0], new BigDecimal(productFields[1]), new BigDecimal(productFields[2])));
            } catch (NumberFormatException e){
                System.err.println("Plik zawiera niepoprawne dane.");
            }
        }

        return products;
    }

}