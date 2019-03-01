import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

class SalesCalculator {

    void calculateNetto(Product product) {

        BigDecimal xxx1 = new BigDecimal("0.01");
        BigDecimal vat = xxx1.multiply(product.getVat());
        BigDecimal netto = product.getBruttoPrice().subtract(product.getBruttoPrice().multiply(vat));

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
            sum = sum.add(product.getVat());

        return sum;
    }

}