package lab4;

public class Worker extends Employee {
    // i hate mylyfe.

    /**
     * @param arg1 = worker's first name.
     * @param arg2 = worker's surname.
     * @param arg3 = worker's employee number.
     * @param arg4 = salary received by the worker.
     *             This constructor is called with the details of the worker and it
     *             passes these on to the constructor of the superclass.
     */
    public Worker(String arg1, String arg2, int arg3, double arg4) {
        super(arg1, arg2, arg3, arg4);
    }


    //compares two workers (employees)
    //arg == worker the current worker is being compared to.
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
        // this worker is higher, equal or lower than that of arg.
    }


    //This instance method computes the taxes the worker has to pay.
    public double computeTaxes() {
        return 0.25 * salary;
    }


}