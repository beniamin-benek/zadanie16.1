import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

class SalesCalculator {

    void calculateNetto(Product product) {

        BigDecimal netto = product.getBruttoPrice().subtract(product.getBruttoPrice().multiply(changeVatFromPercentsToNumber(product)));
        product.setNettoPrice(netto.divide(new BigDecimal("1"),2, RoundingMode.HALF_UP));
    }

    BigDecimal calculateBruttoSum(List<Product> products) {
        BigDecimal sum = new BigDecimal(0);
        for (Product product : products)
            sum = sum.add(product.getBruttoPrice());

        return sum;
    }

    BigDecimal calculateNettoSum(List<Product> products) {
        BigDecimal sum = new BigDecimal(0);
        for (Product product : products)
            sum = sum.add(product.getNettoPrice());

        return sum;
    }

    BigDecimal calculateVatSum(List<Product> products) {
        BigDecimal sum = new BigDecimal(0);
        for (Product product : products)
            sum = sum.add(changeVatFromPercentsToNumber(product).multiply(product.getNettoPrice()));

        return sum.divide(new BigDecimal("1"),2, RoundingMode.HALF_UP);
    }

    private BigDecimal changeVatFromPercentsToNumber(Product product) {
        BigDecimal oneHundredth = new BigDecimal("0.01");
        return oneHundredth.multiply(product.getVat()); //dla np. 23% zwraca 0.23
    }

}