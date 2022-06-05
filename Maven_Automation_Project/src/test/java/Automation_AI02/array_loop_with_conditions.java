package Automation_AI02;

import java.util.ArrayList;

public class array_loop_with_conditions {
    public static void main(String[] args) {
        //create an array with cities print only when city is Brooklyn or city is manhattan
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");
        cities.add("Staten Island");

        for (int i = 0; i < cities.size(); i++) {

            /*
            if (cities.get(i) == "Brooklyn" || cities.get(i) == "Manhattan") {
                System.out.println("My city is " + cities.get(i));


            }//with or operator


           */

            if(cities.get(i)== "Brooklyn"){
                System.out.println("My city is "  + cities.get(i));

            } else if (cities.get(i) == "Manhattan"){
                System.out.println("My city is "  + cities.get (i));


            }//with if conditions

        }//end of loop
    }//end of main method
}//end of java