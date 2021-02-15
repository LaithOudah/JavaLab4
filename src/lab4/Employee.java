package lab4;

import java.util.ArrayList;
import java.util.Collections;
//yes.

//public class Employee implements Comparable<Employee> ?????
public abstract class Employee extends Object implements Comparable<Employee> {
    //criteria used by change criterion.
    public static final int BYNAME = 0;
    public static final int BYSALARY = 1;
    public static final int BYTAXES = 2;

    //class variables - got by guessing based on methods
    protected String firstName;
    protected String surName;
    protected int employeeNumber;
    protected double salary;
    protected static int sortCriterion = 0;

    /**
     * @param arg1 = first name of the employee.
     * @param arg2 = surname of the employee.
     * @param arg3 = employee number.
     * @param arg4 = salary
     *             <p>
     *             The constructor for an employee.
     */
    public Employee(String arg1, String arg2, int arg3, double arg4) {
        //guess-work might be wrong
        firstName = arg1;
        surName = arg2;
        employeeNumber = arg3;
        salary = arg4;

    }


    static void changeCriterion(int arg) {
        if(arg == 0){
            sortCriterion = 0;
        }
        else if(arg == 1){
            sortCriterion = 1;
        }
        else if(arg == 2){
            sortCriterion = 2;
        }
        else{
            System.out.println("Invalid input!");
        }
    }


    //This instance method returns the taxes paid by the
    // employee and it is implemented in the subclasses.
    abstract double computeTaxes();


    //This instance method returns the surname of the employee.
    public String getName() {
        return surName;
    }


    //This instance method returns the employee's number.
    public int getNumber() {
        return employeeNumber;
    }


    public double getSalary() {
        return salary;
    }


    public String toString() {
        /*
        The information about the employee is returned in the form
        first name (12 characters), second name (12 characters)
        and employee number (8 characters).
         */
        if(sortCriterion == 0) {
            //nice output but has no header
            return String.format("%12s\t|\t%12s\t|\t%8d\n", firstName, surName, employeeNumber);
        }
        else if(sortCriterion == 1){
            return String.format("%12s\t|\t%12s\t|\t%8f\n", firstName, surName, salary);

        }
        else{
            return String.format("%12s\t|\t%12s\t|\t%8f\n", firstName, surName, computeTaxes());
        }
    }


}
