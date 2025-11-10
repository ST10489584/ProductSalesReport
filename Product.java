public interface Product { //Defines methods the ProductSales class must have
    int TotalSales(int[] productSales); //Calculates the total of all the sales
    double AverageSales(int[] productSales); //Calculates the average of the sales
    int MaxSale(int[] productSales); //Returns the highest number
    int MinSale(int[] productSales); //Returns the lowest number
}
