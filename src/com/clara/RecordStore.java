package com.clara;

import java.util.*;

/** Inventory for second-hand record store, selling CDs and LPs */

public class RecordStore {

    public static void main(String[] args) {

        //Create some example CDs and add them to an inventory list
        ArrayList<CD> cdInventory = new ArrayList<CD>();

        CD testCD1 = new CD("Lady Gaga", "The Fame Monster", 6.99);
        CD testCD2 = new CD("Bob Dylan", "Basement Tapes", 9.99);

        cdInventory.add(testCD1);
        cdInventory.add(testCD2);

        //Create some example LPs and add them to an inventory list
        ArrayList<LP> lpInventory = new ArrayList<LP>();

        LP testLP1 = new LP("Michael Jackson", "Thriller", 4, 9.99);
        LP testLP2 = new LP("Replacements", "Hootenanny", 3, 7.99);

        lpInventory.add(testLP1);
        lpInventory.add(testLP2);

        System.out.println("All LPs in the inventory:");
        for (LP lp : lpInventory) {
            System.out.println(lp);
        }

        System.out.println("All CDs in the inventory");
        for (CD cd : cdInventory) {
            System.out.println(cd);
        }

        //Create a master inventory list with all Albums in

        ArrayList<Album> allInventory = new ArrayList<Album>();
        allInventory.addAll(lpInventory);
        allInventory.addAll(cdInventory);


        //Search inventory for any CD or LP that matches a search term
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter artist or title to search for. Works for partial artists/titles.");
        String searchString = scanner.next();

        searchForAlbum(allInventory, searchString);

    }

    private static void searchForAlbum(ArrayList<Album> albums, String searchTerm){

        searchTerm = searchTerm.toLowerCase();  //Work in lowercase

        boolean found = false;

        for (Album a : albums) {
            if (a.getTitle().toLowerCase().contains(searchTerm) || a.getArtist().toLowerCase().contains(searchTerm)){
                found = true;
                System.out.println(a);
                //Equivalent to
                //System.out.println(a.toString());
            }
        }

        if (found == false) {
            System.out.println("No matching albums found for this search term");
        }

    }


}

