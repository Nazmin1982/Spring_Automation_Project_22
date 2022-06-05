package Automation_AI01;

import java.util.ArrayList;

public class action1 {
    public static void main(String[] args) {
        //create an arraylist for countries and loop/iterating through all the values using for loop
        ArrayList<String> country=new ArrayList<>();
        country.add("USA");
        country.add("Bangladesh");
        country.add("Brazil");
        country.add("United Kingdom");

        //Create an array list for country code
        ArrayList<Integer>countryCode=new ArrayList<>();
        countryCode.add(1);
        countryCode.add(880);
        countryCode.add(55);
        countryCode.add(44);

        for(int i=0; i <countryCode.size(); i++) {

            System.out.println("my Country is " + country.get(i) + " and my country code is " + countryCode.get(i));


        }//end of for loop

    }//end of main
}//end of automation hw
