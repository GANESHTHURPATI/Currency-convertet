import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display available currencies
        System.out.println("Welcome to Currency Converter!");
        System.out.println("Available currencies: USD, EUR, GBP, INR, JPY");
        
        // Enter source currency
        System.out.print("Enter source currency (e.g., USD): ");
        String sourceCurrency = scanner.next().toUpperCase();

        // Enter target currency
        System.out.print("Enter target currency (e.g., INR): ");
        String targetCurrency = scanner.next().toUpperCase();

        // Enter amount
        System.out.print("Enter amount in " + sourceCurrency + ": ");
        double amount = scanner.nextDouble();

        // Conversion rates (Example rates, these should be updated dynamically)
        double conversionRate = getConversionRate(sourceCurrency, targetCurrency);

        if (conversionRate == 0.0) {
            System.out.println("Invalid currency selection.");
        } else {
            // Convert currency
            double convertedAmount = amount * conversionRate;
            System.out.printf("Converted Amount: %.2f %s\n", convertedAmount, targetCurrency);
        }

        // Close scanner
        scanner.close();
    }

    // Function to get conversion rates (Static rates for demonstration)
    public static double getConversionRate(String from, String to) {
        // Sample conversion rates (You can update these dynamically from an API)
        double[][] rates = {
            // USD,   EUR,   GBP,   INR,   JPY
            {1.0,   0.91,  0.76,  82.91,  114.51}, // USD
            {1.10,  1.0,   0.84,  91.23,  125.67}, // EUR
            {1.32,  1.19,  1.0,   108.67, 149.23}, // GBP
            {0.012, 0.011, 0.0092, 1.0,   1.37},   // INR
            {0.0087,0.0079,0.0067, 0.73,  1.0}     // JPY
        };

        String[] currencies = {"USD", "EUR", "GBP", "INR", "JPY"};

        int fromIndex = -1, toIndex = -1;

        for (int i = 0; i < currencies.length; i++) {
            if (currencies[i].equals(from)) {
                fromIndex = i;
            }
            if (currencies[i].equals(to)) {
                toIndex = i;
            }
        }

        if (fromIndex == -1 || toIndex == -1) {
            return 0.0; // Invalid currency
        }

        return rates[fromIndex][toIndex];
    }
}
