public class ProductSalesTest {

    public static void main(String[] args) {

        int[] sales = {300, 150, 700, 250, 200, 600};
        ProductSales ps = new ProductSales();

        //Test for TotalSales
        int expectedTotal = 2200;
        int actualTotal = ps.TotalSales(sales);
        System.out.println("TotalSales Test: " + (expectedTotal == actualTotal));

        //Test for AverageSales
        double expectedAvg = 366.67;
        double actualAvg = ps.AverageSales(sales);
        System.out.println("AverageSales Test: " + (Math.abs(expectedAvg - actualAvg) < 0.01));
    }
}
