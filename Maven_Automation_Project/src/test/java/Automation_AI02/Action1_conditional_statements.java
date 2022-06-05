package Automation_AI02;

public class Action1_conditional_statements {
    public static void main(String[] args) {
                    //if grade range is 90 to 100 print a
                int grade= 80;
                if(grade >= 90&& grade <= 100) {
                    System.out.println("print grade is A");

                     // if grade range is 80 to 90 print b
                } else if (grade>=80 && grade <90) {
                    System.out.println("print grade is B");

                    //if grade range is 70 to 80 print c
                }else if (grade >=70 && grade <80) {
                    System.out.println("print grade is C");

                    //if grade range is below 60 to 70 print d
                }else if (grade >=60 && grade <70) {
                    System.out.println("print grade is D");

                    //if grade range is below 60 print f
                }else {
                    System.out.println("print grade is  F");
                }

    }//end of main
}//end of java
