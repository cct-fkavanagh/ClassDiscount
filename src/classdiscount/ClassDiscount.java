/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package classdiscount;
import java.time.LocalDate; // added to set current date beforehand
/**
 *
 * @author Francis
 */
public class ClassDiscount {

    public static double calculateDiscountedPrice(int custClass, int yearCust, double valPrice) {
        
        double valDiscount = valPrice;
        int currYear = LocalDate.now().getYear();
        
        if (custClass == 1 && yearCust == currYear) {
            valDiscount = valPrice * 0.7;
            System.out.println("Applied 30% Discount");
            return valDiscount;
            
        } else if(custClass == 1 && yearCust < currYear) { //can i add a loop to make the last 5 years more accurate?
            valDiscount = valPrice * 0.8;
            System.out.println("Applied 20% Discount");
            return valDiscount;
            
        } else if(custClass == 1 && yearCust < currYear - 5) {
            valDiscount = valPrice * 0.9;
            System.out.println("Applied 10% Discount");
            return valDiscount;
            
        } else if (custClass == 2 && yearCust == currYear ) {
            valDiscount = valPrice * 0.85;
            System.out.println("Applied 15% Discount");
            return valDiscount;
            
        } else if (custClass == 2 && yearCust < currYear) { //can i add a loop to make the last 5 years more accurate?
            valDiscount = valPrice * 0.87;
            System.out.println("Applied 13% Discount");
            return valDiscount;
            
        } else if (custClass == 2 && yearCust < currYear - 5) {
            valDiscount = valPrice * 0.95;
            System.out.println("Applied 5% Discount");
            return valDiscount;
            
        } else if (custClass == 3 && yearCust == currYear) {
            valDiscount = valPrice * 0.97;
            System.out.println("Applied 3% Discount");
            return valDiscount;
        } else if (custClass == 3 && yearCust < currYear - 5) {
            System.out.println("No Discount Applied");
            return valPrice;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int currYear = LocalDate.now().getYear();
        LoopClass loop = new LoopClass();
    
    }
    
}
