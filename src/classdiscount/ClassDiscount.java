package classdiscount;
import java.time.LocalDate; // added to set current date beforehand
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francis
 */
public class ClassDiscount {

    public static double calculateDiscountedPrice(String custName, int custClass, int yearCust, double valPrice) {
        
        double valDiscount = valPrice;
        int currYear = LocalDate.now().getYear();
        
        if (custClass == 1 && yearCust == currYear) {
            valDiscount = valPrice * 0.7;
            System.out.println("Applied 30% Discount:");
            
        } else if(custClass == 1 && yearCust < currYear) {
            valDiscount = valPrice * 0.8;
            System.out.println("Applied 20% Discount:");
            
        } else if(custClass == 1 && yearCust < currYear - 5) {
            valDiscount = valPrice * 0.9;
            System.out.println("Applied 10% Discount:");
            
        } else if (custClass == 2 && yearCust == currYear ) {
            valDiscount = valPrice * 0.85;
            System.out.println("Applied 15% Discount:");
            
        } else if (custClass == 2 && yearCust < currYear) {
            valDiscount = valPrice * 0.87;
            System.out.println("Applied 13% Discount:");
            
        } else if (custClass == 2 && yearCust < currYear - 5) {
            valDiscount = valPrice * 0.95;
            System.out.println("Applied 5% Discount:");
            
        } else if (custClass == 3 && yearCust == currYear) {
            valDiscount = valPrice * 0.97;
            System.out.println("Applied 3% Discount:");
            
        } else if (custClass == 3 && yearCust < currYear) {
            System.out.println("No Discount Applied:");
            return valPrice;
                    
        } else if (custClass < 1) { //displays error message if a valid customer class is not detected
            System.out.println("ERROR DETECTED!! Invalid Customer Class. Customer Class = " + custClass + " - No Discount Applied");
            return valPrice;
        }
        
        return valDiscount;
    }
    
// github link: https://github.com/cct-fkavanagh/ClassDiscount

    public static void main(String[] args) {

        File file = new File("customers.txt"); //designating what file I want read
        Scanner scan = null; //scanner set up outside try/catch so it can be used later
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) { // renamed to 'e' to avoid conflicts with ln 92
            Logger.getLogger(ClassDiscount.class.getName()).log(Level.SEVERE, null, e);
        }
        try (BufferedWriter out = new BufferedWriter(new FileWriter("customerdiscount.txt"))) {
            while(scan.hasNextLine()) {           
            String custName = scan.nextLine(); //scans for customer name
            double valPrice = Double.parseDouble(scan.nextLine()); //scans for total customer is spending
            int custClass = Integer.parseInt(scan.nextLine()); // scans for customer class
            int yearCust = Integer.parseInt(scan.nextLine()); // scans for the last purchase year from customer
            
            double valDiscount = calculateDiscountedPrice(custName, custClass, yearCust, valPrice);
            
            out.write(custName); //  write the customer's name first
            out.newLine(); // writes to the next line
            out.write(String.valueOf(valDiscount)); // writes the total after the discount on a new line
            out.newLine();
            }
        } catch (IOException ex) { 
            Logger.getLogger(ClassDiscount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}    
