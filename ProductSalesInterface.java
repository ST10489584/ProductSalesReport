public interface ProductSalesInterface { //Defines methods for product GetSalesOverLimit
    //Calulations
    int[] GetProductSales(); //Returns array of product sales
    int GetTotalSales(); //returns the total sales
    int GetSalesOverLimit(); //returns the number of sales over sales limit 
    int GetSalesUnderLimit(); //returns the number of sales under sales limit
    int GetProductsProcessed(); //Returns number of years processed
    double GetAverageSales(); //Returns the average sales rounded up
}
