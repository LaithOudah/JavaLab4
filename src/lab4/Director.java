package lab4;

import java.util.ArrayList;
//Commenting ur mom

public class Director extends Employee {
    ArrayList<Worker> subordinates;


    /**
     * @param arg1 = director's first name
     * @param arg2 = director's second name
     * @param arg3 = director's employee number
     * @param arg4 = salary received by the director
     */
    public Director(String arg1, String arg2, int arg3, double arg4) {
        super(arg1, arg2, arg3, arg4);
        subordinates = new ArrayList<Worker>();

    }

    //This instance method adds a worker to the list
    //list of subordinates (or bitches 'n hoes) of the director.
    public void addEmployee(Worker arg) {
        subordinates.add(arg);
    }


    //                  TODO: fix this shit.
    //----------------------------------------------------------------|
    //compares two directors (employees)                              |
    //arg == director the current director is being compared to.
    //By name
    public int compareTo(Employee arg) {
        if(sortCriterion == 0){
            return firstName.compareToIgnoreCase(arg.firstName);
        }
        //by salary
        else if(sortCriterion == 1) {
            return Double.compare(salary, arg.salary);
        }
        //by taxes
        else {
            return Double.compare(computeTaxes(),arg.computeTaxes());
        }

        //returns -1, 0, 1 depending on if the salary of
        // this director is higher, equal or lower than that of arg.

        //how do i implement the salary of the employee that is
        //being compared against arg?
    }
    //-----------------------------------------------------------------

    //This instance method computes the bonus of the director.
    public double computeBonus() {
        //pseudo-code
        //loop through ArrayList of subordinates
        //add up total salary of all employees under the specific director
        //bonus = 10% of total salary of subordinates
        double sum = 0;
        for (int i = 0; i < subordinates.size(); i++) {
            sum += subordinates.get(i).salary;
        }
        return 0.1 * sum;
    }


    // This instance method computes the taxes the director has to pay.
    // The taxes are 25 per cent of the sum of the salary and the bonus.
    public double computeTaxes() {
        return 0.25 * (salary + computeBonus());
    }


}
