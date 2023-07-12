package starbacks;
/**
 * Requirement:
 * 1. Basic Java Syntax
 * 2. Array & Arrylist
 * 3. Function
 * 4. Math
 * 5. Sort & Order
 * 6. static property
 */

import java.util.Scanner;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;  
import java.util.List;  

class Application {
    
    public static Scanner scanner = new Scanner(System.in);

    public static int input = 0;

    public static String name = "";

    public static String[] menuName = new String[] {
        "Caffe Americano", 
        "Caramel Macchiato", 
        "Cappuccino",
        "Signature Chocolate",
        "Strawberry Acai",
        "Pink Drink"
    };

    public static int MENU_CHECK_ORDER      = menuName.length + 1;
    public static int MENU_CHEKOUT_ORDER    = menuName.length + 2;
    public static int MENU_CANCEL_ORDER     = menuName.length + 3;

    public static int[] menuPrice = new int[] {
        38000, 
        55000, 
        45000,
        65000,
        55000,
        70000
    };

    public static List<Integer> orders = new ArrayList<Integer>();

    public static void main(String[] args) {

        do {
            clearData();

            do {
                clearscreen();

                System.out.println("Please input your name [quit to exit program]:");
            
                name = scanner.nextLine();
            } while (name.length() == 0);

            clearscreen();

            if(!name.equalsIgnoreCase("quit")) {
                System.out.println("Hallo " + name + ", Welcome to starbacks!!");
        
                pressEnterToContinue();
        
                menu();

                clearscreen();

                System.out.println("Thank you " + name + ", see you again!!");
                scanner.nextLine();

                pressEnterToContinue();
            }
        } while(!name.equalsIgnoreCase("quit"));
    }
    
    public static void clearData() {
        input   = 0;
        name    = "";
        orders  = new ArrayList<>();
    }

    public static void menu() {
        do {
            clearscreen();

            System.out.println("== [Today's Menu] ==");
            System.out.println("");
    
            for(int i = 0; i < menuName.length ; i++) {
                System.out.println(i + 1 + ". " + menuName[i] + " @" + menuPrice[i]/1000 + "k");
            }
            
            System.out.println(MENU_CHECK_ORDER + ". " + "Check my order");
            System.out.println(MENU_CHEKOUT_ORDER + ". " + "Checkout order and do payment");
            System.out.println(MENU_CANCEL_ORDER + ". " + "Cancel Purchase");

            if(orders.size() == 0) {
                System.out.println("Can i have your order [input option: 1.." + MENU_CANCEL_ORDER + "]");
            } else {
                System.out.println("Anything else maybe [input option: 1.." + MENU_CANCEL_ORDER + "]");
            }

            try {
                input = scanner.nextInt();

                if(input > MENU_CANCEL_ORDER) {
                    input = 0;

                    System.err.println("Sorry we don't have that..");    
                    scanner.nextLine();
                
                    pressEnterToContinue();
                } else if(input == MENU_CHECK_ORDER) {
                    check_order();
                } else if(input == MENU_CHEKOUT_ORDER) {
                    check_out_order();
                } else if(input != MENU_CANCEL_ORDER) {
                    add_order(input);
                }

            } catch (Exception e) {
                System.err.println("Sorry we don't have that..");
                scanner.nextLine();
                
                pressEnterToContinue();
            }    
        } while (input == 0 || input < MENU_CHEKOUT_ORDER);
        
    }

    public static void pressEnterToContinue() {
        System.out.println("Press Enter to continue..");
        scanner.nextLine();
    }

    public static void clear(int line) {
        for(int i = 0; i < line; i++) {
            System.out.println("");
        }
    }

    public static void clearscreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void add_order(int input) {
        clearscreen();

        orders.add(input);

        System.out.println("1 x " + menuName[input - 1] + " @" + menuPrice[input - 1]/1000 + "k");
        scanner.nextLine();
        
        pressEnterToContinue();
    }

    public static void check_order() {
        clearscreen();

        System.out.println(orders);

        if(orders.size() == 0) {
            System.out.println("Sorry, you haven't ordered anything..");
        } else {
            sumarize_menu(false);
        }

        scanner.nextLine();
                
        System.out.println("");
        
        pressEnterToContinue();
    }

    public static void check_out_order() {
        clearscreen();

        if(orders.size() == 0) {
            System.out.println("Sorry, you haven't ordered anything..");
        } else {
            sumarize_menu(true);
        }

        scanner.nextLine();
                
        pressEnterToContinue();
    }

    public static void sumarize_menu(boolean withTotalPayment) {
        System.out.println("== [" + name + " Order's] ==");
        System.out.println("");

        int totalPrice  = 0;

        for(int i = 0; i < menuName.length; i++) {

            int counter     = 0;
            
            for(int j = 0; j < orders.size(); j++) {
                if(i == orders.get(j) - 1) {
                    counter++;
                }
            }

            if(counter > 0) {
                System.out.println(counter + " x " + menuName[i] + " @" + menuPrice[i]/1000 + "k");
                totalPrice += (menuPrice[i] * counter);
            }
        }

        if(withTotalPayment) {
            DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance();
            decimalFormatSymbols.setDecimalSeparator('.');

            System.out.println("");
            System.out.println("Total: IDR " + price_format(totalPrice) + ",-");

            Integer payment = 0;

            do {
                try {
                    System.out.println("Enter payment amount:");

                    payment = scanner.nextInt();

                    if(payment < totalPrice) {
                        System.out.println("Insufficient payment amount");

                        scanner.nextLine();

                        pressEnterToContinue();

                        clearscreen();
                    }
 
                } catch (Exception e) {
                    System.err.println("Sorry wrong input!!");
                    scanner.nextLine();
                
                    pressEnterToContinue();

                    payment = 0;

                    clearscreen();
                }
            } while (payment < totalPrice);
 
            if(payment > totalPrice) {
                System.out.println("Thank you and here is your change @" + (payment - totalPrice) + ", Please wait for your order");
            } else {
                System.out.println("Thank you!!, Please wait for your order");
            }

        }
    }

    public static String price_format(int price) {
        String tmp = "";

        int counter = 0;

        for(int i = String.valueOf(price).length(); i > 0; i--) {
            counter++;

            if(counter == 3 && i != 1) {
                tmp = tmp + String.valueOf(price).charAt(i - 1) + ".";

                counter = 0;
            } else {
                tmp = tmp + String.valueOf(price).charAt(i - 1);
            }

        }

        String result = "";

        for (int i = 0; i < tmp.length(); i++) {
            result = tmp.charAt(i) + result; 
        }

        return result;
    }
}