package Automation_AI01;

public class action2 {

    public static void main(String[] args) {
        //iterate through region and its areaCode using linear array and while loop
        String[] region= new String[]{"NY","CA","TX","PA"};
        int[] areaCode = new int[]{212,213,214,215};

        //initialize your starting point before calling while loop
        int i=0;

        //define the end point in while loop
        while (i < areaCode.length) {
            System.out.println("My region is " + region[i] + " and my areaCode is " + areaCode[i]);
            //incrementing
            i = i +1;

        }//end of while loop
    }//end of main
}//end of java class



