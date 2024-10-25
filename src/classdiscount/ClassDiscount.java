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
        
        switch(custClass){
                case 1:
                    if(yearCust < currYear - 5){
                        valDiscount = valPrice  * 0.8;
                        System.out.println("Total after 20% discount: " + valDiscount);
                    }
                    }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    }
    
}
