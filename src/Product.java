import java.math.BigDecimal;

class Product {

    private String name;
    private BigDecimal bruttoPrice;
    private BigDecimal nettoPrice;
    private BigDecimal vat;

    public Product(String name, BigDecimal bruttoPrice, BigDecimal vat) {
        this.name = name;
        this.bruttoPrice = bruttoPrice;
        this.vat = vat;
    }

    @Override
    public String toString() {
        return "{ Produkt: " + name + ", cena brutto: " + bruttoPrice + " zł, cena netto: " + nettoPrice + " zł, vat: " + vat + "% }";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBruttoPrice() {
        return bruttoPrice;
    }

    public void setBruttoPrice(BigDecimal bruttoPrice) {
        this.bruttoPrice = bruttoPrice;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public BigDecimal getNettoPrice() {
        return nettoPrice;
    }

    public void setNettoPrice(BigDecimal nettoPrice) {
        this.nettoPrice = nettoPrice;
    }
}