package Biller.System.Managment;

import java.util.HashMap;
import java.util.Scanner;
import static Biller.System.Managment.Product.products;

public class Biller{

    private int totalSale;
    private static boolean loggedIn = false;
    private static int optionValue;




    /***
     * Main Meny of Default Page for
     * Registering, Logining In or Exit
     */
    public static void mainPage(){
        if (!loggedIn){

            System.out.println("                                             BILLER V.0.01               ");
            System.out.println("                                             Created by Eganathan.R               ");
            System.out.println("              1. Login");
            System.out.println("              2. Register");
            System.out.println("              3. Exit");
            System.out.println("     please enter your preferred option number below ");

            Scanner sc = new Scanner(System.in);
            optionValue = sc.nextInt();

            if(optionValue == 1){
                System.out.println("Please enter your User name below");

                Scanner lSc = new Scanner(System.in);
                String uName= lSc.nextLine();

                System.out.println("Please enter your password below");
                String uPass= lSc.nextLine();

                Account.login(uName,uPass);

            }else if(optionValue == 2){

                System.out.println("Please enter a new User name below");

                Scanner nSc = new Scanner(System.in);
                String uName= nSc.nextLine();

                System.out.println("Please enter a new password below");
                String uPass= nSc.nextLine();

                Account.register(uName,uPass);
            }else if(optionValue == 3){
                System.out.println("See you later!!");
                System.exit(0);

            }else{
                System.out.println("Please Try Again !!");
                mainPage();
            }
        }}


    /***
     * Option Menu for navigation after logged in is TRUE
     * Enable to Select a preffered option for logged in object
     */
    public static void optionMenu(boolean x){
        if(true){
            System.out.println("                    BILLER MENU");
            System.out.println( "                             ");
            System.out.println("       1. Biller");
            System.out.println("       2. Customers");
            System.out.println("       3. Add new product");
            System.out.println("       4. Add new customer");
            System.out.println("       5. Add new Cashier");
            System.out.println("       6. Add new Cashier");
            System.out.println("       7. Sales Analytics");
            System.out.println("       8. Log Out");
            System.out.println("       9. EXIT");

            Scanner opMS = new Scanner(System.in);
            int opVal = opMS.nextInt();
            Options(opVal);
        }else{
            x = false;
            System.out.println("Please Login Again!");
            mainPage();
        }} //END of Option Menu

    /***
     * Checking the selected option from Option manu and directing to related methods
     * if invalid value is entered prints the same
     * @param optVal is the selected value from the Option Menu
     */
    public static void Options(int optVal){

        if(optVal == 1){

        }else if(optVal == 2){

        }else if(optVal == 3){
            boolean addMore = true;
            do{
                System.out.println("Add a new product ");
                Scanner ov = new Scanner(System.in);
                System.out.println("Please enter the product name :");
                String pName = ov.nextLine();
                System.out.println("Please enter a price for "+ pName);
                int iPrice = ov.nextInt();
                Product.addProduct(pName,iPrice);
                System.out.println("Product added successfully!");
                System.out.println("Enter 1 to go back else click ENTER");
                int cont = ov.nextInt();
                if(cont == 1){
                    addMore = false;
                    optionMenu(true);
                } else{
                    Options(3);
                }

            }while(addMore);


        }else if(optVal == 4){

        }else if(optVal == 5){

        }else if(optVal == 6){

        }else if(optVal == 7){

        }else if(optVal == 8){

            System.out.println("Are you sure you want to logout ?");

            //rcnf = re confirm
            Scanner rcnf = new Scanner(System.in);
            //rcv = re confirm value
            int rcv = rcnf.nextInt();

            if(rcv == 1){
                optionMenu(false);
            }else{
                System.out.println("Good Choice!!");
                optionMenu(true);

            }


        }else if(optVal == 9){

            System.exit(0);

        }else{
            System.out.println("please enter a valid number!");
        }
    }

    public static void bill(){
        int saleAmount = 0;
        int currAmount = 0;
        boolean cont = true;

        do{
            Scanner bScan = new Scanner(System.in);
            System.out.println("Enter the Item name:");
            String iName = bScan.nextLine();
            if(products.containsKey(iName)){
                System.out.println("Enter the Qty:");
                int iQty = bScan.nextInt();
                currAmount =  products.get(iName)* iQty;
                saleAmount += currAmount;
                System.out.println("Bill Amount : " +currAmount);
                System.out.println("Total Sale : " +saleAmount);
            }else{
                cont = false;
                optionMenu(true);
            }

        }while(cont);
        optionMenu(true);
    }





    public static void main(String[] arg){

        mainPage();


    }
}
