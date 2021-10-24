package Biller.System.Managment;

import java.util.HashMap;

public class Product {

    static HashMap<String, Integer> products = new HashMap<>();


    public static void addProduct(String pName, int iPrice){
        products.put(pName,iPrice);
        System.out.println("here is the updated List");
    }
}
