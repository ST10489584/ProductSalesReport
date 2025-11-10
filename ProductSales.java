public class ProductSales implements Product { //Implements the product interface
//logic for the calculations
    @Override
    public int TotalSales(int[] productSales) { //Calculates the total of all the sales
        int total = 0;
        for (int sale : productSales) {
            total += sale;
        }
        return total;
    }

    @Override
    public double AverageSales(int[] productSales) { //Calculates the average of the sales
        return (double) TotalSales(productSales) / productSales.length;
    }

    @Override
    public int MaxSale(int[] productSales) { //Returns the highest number
        int max = productSales[0];
        for (int sale : productSales) {
            if (sale > max) {
                max = sale;
            }
        }
        return max;
    }

    @Override
    public int MinSale(int[] productSales) {//Returns the lowest number
        int min = productSales[0];
        for (int sale : productSales) {
            if (sale < min) {
                min = sale;
            }
        }
        return min;
    }
}
