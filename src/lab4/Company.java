package lab4;

import java.util.ArrayList;
import java.util.Collections;
// Comment

public class Company extends Object {
    protected Employee theEmployee;
    //protected Director theDirector;
    ArrayList<Employee> allEmployees;

    public Company() {
        allEmployees = new ArrayList<Employee>();
    }

    public void addEmployee(Director arg) {
        //This instance method adds a director to the dynamic array of employees.
        allEmployees.add(arg);
    }

    //This instance method adds a worker to the dynamic array of employees
    // and attaches it to one director.
    public void addEmployee(Worker arg1, Director arg2) {
        theEmployee = arg1; //assigns the employee as a worker (arg1) with its corresponding variables, firstName, surName etc...
        allEmployees.add(theEmployee); //adds the employee to the list of all employees
        arg2.addEmployee(arg1); //adds the worker to the list of subordinates of the director


        //thoughts
        //------------------------------------------------------------------
        //can the worker be accessed through the director?
        //might be throwing this shit out of sync.
        //Just like savingsAccount depended on CurrentAccount, maybe workers depend on Directors
        //-------------------------------------------------------------------
    }

    /**
     * This instance method writes out a header followed by the sorted list
     * of employees. It creates a title string that depends on the sorting
     * criterion, it sorts the list of employees according to the criterion
     * and concatenates the return values of the toString methods of all
     * employees to one large string, which is then returned.
     */
    public String toString() {
        StringBuilder finished = new StringBuilder();
        if(theEmployee.sortCriterion == 0){
            Collections.sort(allEmployees);
                for(Employee str: allEmployees) {
                finished.append(str);
                }
        }
        else{
            Collections.sort(allEmployees);
            Collections.reverse(allEmployees);
            for(Employee str: allEmployees) {
                finished.append(str);
            }
        }



        return finished.toString(); //same as always, good lookin' :*
    }


}
