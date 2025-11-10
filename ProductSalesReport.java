public class ProductSalesReport {

    public static void main(String[] args) {

        //two-dimensional arrays, Showing year 1 and year 2
        //Each row represents a year and each column represents a quarter
        int[][] salesData = {
            {300, 150, 700},  //In year 1 we have Quarter 1, Quarter 2, Quarter3
            {250, 200, 600}   //In year 2 we have Quarter 1, Quarter 2, Quarter 3
        };

        //Making the two-dimentional array into a one-dimensional array, for easier calculations
        int[] allSales = new int[6];
        int index = 0;

        //looping the two-dimentional into one-dimensional, placing all the values
        for (int[] year : salesData) {
            for (int sale : year) {
                allSales[index] = sale;
                index++;
            }
        }
        //Object for ProductSales
        ProductSales ps = new ProductSales();

        int total = ps.TotalSales(allSales); //Calculating using ProductSales methods
        int average = (int)Math.floor(ps.AverageSales(allSales)); //Calculating average converting into int, removes the decimals
        int max = ps.MaxSale(allSales);
        int min = ps.MinSale(allSales);

        System.out.println("PRODUCT SALES REPORT - 2025"); //This is the output
        System.out.println("-------------------------------");
        System.out.println("Total sales: " + total);
        System.out.println("Average sales: " + average);
        System.out.println("Maximum sale: " + max);
        System.out.println("Minimum sale: " + min);
        System.out.println("-------------------------------");
    }
}
