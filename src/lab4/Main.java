package lab4;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Main {

	public static void main(String[] args)  {

		Company theCompany = new Company();

		/* Directors are created as objects with an own reference variable because they are added to
		 * Workers. The entries in the constructor are the first name, surname, employee number and salary. */

		Director director1 = new Director("John", "Smith", 1, 700000.0);
		Director director2 = new Director("Elaine", "Garret", 2, 670000.0);

		// We add the directors to the company

		theCompany.addEmployee(director1);
		theCompany.addEmployee(director2);

		// We add workers to the company and assign them to a director.

		theCompany.addEmployee(new Worker("Paul", "Johnson", 3, 400000.0), director1);
		theCompany.addEmployee(new Worker("Sarah", "Davidson", 4, 420000.0), director1);
		theCompany.addEmployee(new Worker("Doris", "McClure", 5, 470000.0), director1);
		theCompany.addEmployee(new Worker("James", "Adams", 6, 340000.0), director1);
		theCompany.addEmployee(new Worker("Sam", "Cooper", 7, 460000.0), director2);
		theCompany.addEmployee(new Worker("Andrea", "Lester", 8, 460000.0), director2);
		theCompany.addEmployee(new Worker("Olga", "Gibbs", 9, 420000.0), director2);

		//Here we change the sorting criterium using the class constants of Employee:
		//BYNAME = 0, BYSALARY = 1, BYTAXES = 2.



//                                           part B
		//------------------------------------------------------------------------------------------------------------------------

		Employee.changeCriterion(Employee.BYNAME);
		System.out.println("\n");
		System.out.println("\tFirst name\t\t\tLast name\t\t Employee number");
		System.out.println("\t-------------------------------------------------");
		System.out.println(theCompany);


		Employee.changeCriterion(Employee.BYSALARY);
		System.out.println("\n");
		System.out.println("\tFirst name\t\t\tLast name\t\t salary");
		System.out.println("\t-------------------------------------------------");
		System.out.println(theCompany);

		Employee.changeCriterion(Employee.BYTAXES);
		System.out.println("\n");
		System.out.println("\tFirst name\t\t\tLast name\t\t taxes");
		System.out.println("\t-------------------------------------------------");
		System.out.println(theCompany);







		//                                           part C
		//------------------------------------------------------------------------------------------------------------------------

		JFrame myFrame = new JFrame();
		myFrame.setSize(600, 300);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font f = new Font("Courier New", Font.BOLD, 20);

		//using boolean validInput to re-open popup if previous input was incorrect.
		boolean validInput = false;		//is initially set to false or the code wont run.
		while(!validInput) {
			String input = JOptionPane.showInputDialog("input sorting method:\n0: sort by name.\n1: sort by salary.\n2: sort by taxes.");
			try {
				if (input.equals("0") || input.equals("1") || input.equals("2")) { 		//could have used switch but too much code

					Employee.changeCriterion(Integer.parseInt(input));				//makes the string input into an int and passes it into the changeCriterion() function.
					myFrame.getContentPane().add(new JOptionPane("Employees sorted as requested\n\n" + theCompany.toString()));
					myFrame.setFont(f);
					myFrame.setVisible(true);
					validInput = true;
				}
				else{
					throw new IOException(); //anything except 0, 1, 2 is thrown
				}
			}
			catch(IOException e){
				JOptionPane.showMessageDialog(null, "Invalid input!");
				validInput = false; //setting validInput to run re-open popup if previous input was invalid.
			}
		}








	//                                           oops wrong method
	//------------------------------------------------------------------------------------------------------------------------




		/*
		//using boolean validInput to re-open popup if previous input was incorrect.
		boolean validInput = false;		//is initially set to false or the code wont run.
		while(!validInput) {
			//String input = JOptionPane.showInputDialog("input sorting method:\n0: sort by name.\n1: sort by salary.\n2: sort by taxes.");
			try {
				if(input.equals("0") || input.equals("1") || input.equals("2")) {   //could have used switch but too much code
					Employee.changeCriterion(Integer.parseInt(input)); 				//makes the string input into an int and passes it into the changeCriterion() function .
					String output = theCompany.toString();
					JOptionPane.showMessageDialog(null, output);
					validInput = true;
				}
				else{
					throw new IOException(); //anything except 0, 1, 2 is thrown
				}

			}
			catch(IOException ex){
				JOptionPane.showMessageDialog(null, "Invalid input!");
				validInput = false; //setting validInput to run re-open popup if previous input was invalid.
			}
		}

		 */

	}
}
