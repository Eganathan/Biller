package Biller.System.Managment;

import java.util.HashMap;

public class Account {
    /***
     * Hash map for saving the credentials
     */
    static HashMap<String, String> credentials = new HashMap<>();




    public static void login(String uName, String uPass){
        if (credentials.containsKey(uName) ){

            if(credentials.get(uName).equals(uPass)){
                System.out.println("Logged in Successfully!!");
                Biller.optionMenu(true);
            }else{

                System.out.println("incorrect Password");
                Biller.mainPage();

            }


        }else{

            System.out.println("Please Try again! ");
            Biller.mainPage();

        }
    }

    public static void register(String uName, String uPass){
        credentials.put(uName,uPass);
        System.out.println("Registered Successfully PLeas Login ");
        Biller.mainPage();

    }





}
