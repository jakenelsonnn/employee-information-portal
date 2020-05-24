// Program: PROGRAMMING II FINAL - Employee Information System
// Written by: Jacob Nelson
// Description: Create an employee information system allowing administrative access to create, update, delete, search for, and get information pertaining to employees at some company.
// Challenges: The most challenging part about this program was implementing object inheritance properly.
// Time Spent: 5 to 6 hours total


//                   Revision History
// Date:                   By:               Action:
// ---------------------------------------------------
// 04/07/2020              (JN)              Creation
// <several other days>    (JN)              Building
// 04/07/2020              (JN)              Finished and added additional comments

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeClient
{
    
    public static void main(String args[])
    {
        //creating the arraylist that will hold employee information
        ArrayList<GenerateID> roster = new ArrayList();
        Scanner inp = new Scanner(System.in);
            
        String input = "";
    
        while(!"7".equals(input))
        {
            //displaying the options to the user
            displayMenu();
            input = inp.nextLine();
            switch(input)
            {
                //enter a new employee
                case "1":
                {
                    newEmployee(roster);
                    break;
                }
                case "2":
                {
                    editInfo(roster);
                    break;
                }
                //delete an employee
                case "3":
                {
                    removeEmployee(roster);
                    break;
                }
                //search for an employee
                case "4":
                {
                    search(roster);
                    break;
                }
                //display all employees in the roster + their info
                case "5":
                {
                    displayAll(roster);
                    break;
                }
                //get information about the budget
                case "6":
                {
                    budgetInfo(roster);
                    break;
                }
                //terminate the program
                case "7":
                {
                    break;
                }
            }
        }
    }
    //displayMenu simply outputs text showing the admin's options
    public static void displayMenu()
    {
        System.out.print("EMPLOYEE INFORMATION PORTAL\n\n"
                + "1.   Add Employee\n"
                + "2.   Edit Employee Info\n"
                + "3.   Remove Employee by Name\n"
                + "4.   Search For Employee by Name\n"
                + "5.   Display All Employees and Information\n"
                + "6.   Budget Info\n"
                + "7.   Exit\n");
    }
    
    //newEmployee takes a GenerateID arraylist as parameter
    //it creates a GenerateID object, iterates through each of its set functions
    //and adds it to the arraylist.
    public static void newEmployee(ArrayList<GenerateID> roster)
    {
        GenerateID a = new GenerateID();
        Scanner inp = new Scanner(System.in);
        
        System.out.println("Enter the employee's first name");
        String n = inp.nextLine();
        a.department.setFirstName(n);
        
        System.out.println("Enter the employee's last name");
        n = inp.nextLine();
        a.department.setLastName(n);
        
        System.out.println("Enter the employee's department");
        n = inp.nextLine();
        a.department.setDepartment(n);
        
        System.out.println("Enter the employee's phone number");
        n = inp.nextLine();
        a.department.setPhoneNum(n);
        
        System.out.println("Enter the employee's address");
        n = inp.nextLine();
        a.department.setAddress(n);
        
        System.out.println("Enter the employee's e-mail address");
        n = inp.nextLine();
        //input validation: makes sure the user's input is a valid e-mail
        do
        {
            if(!n.contains("@"))
            {
                System.out.println("Please enter a valid e-mail address.");
                n = inp.nextLine();
            }
        }while(!n.contains("@"));
        a.department.setEmail(n);        
        
        System.out.println("Enter the employee's job title");
        n = inp.nextLine();
        a.department.setTitle(n);
        
        //adds the GenerateID object, with all its info set, to the arraylist
        roster.add(a);
        
        System.out.println("\nEmployee information added for " + a.department.getFirstName() + " " + a.department.getLastName());
        System.out.println("Employee ID: " + a.getEmployeeID());
        System.out.println("Position ID: " + a.getPositionNumber());
        System.out.println("The size of the Employee Roster is now " + roster.size());
        
    }
    
    //removeEmployee asks the user for desired employee's first name, then their last name,
    //and iterates through the arraylist, checking to see the names the user enter matches a name
    //in the arraylist. If so, the employee is removed. If not, the program simply says
    //employee not found.
    public static void removeEmployee(ArrayList<GenerateID> roster)
    {
        System.out.println("Please enter the employee's first name");
        Scanner inp = new Scanner(System.in);
        String first = inp.nextLine();
        
        System.out.println("Please enter the employee's last name");
        String last = inp.nextLine();
        
        boolean found = false;
        
        for(int i = 0; i < roster.size(); i++)
        {
            if((roster.get(i).department.getFirstName().equals(first)) && (roster.get(i).department.getLastName().equals(last)))
            {
                System.out.println("Employee found and removed.");
                roster.remove(i);
                found = true;
                break;
            }
        }
        
        if(found == false)
        {
            System.out.println("Employee not found.");
        }
    }
    
    //similar to above, this function asks the user for the desired employee's first and last name
    //and iterates through the arraylist. If there is a match, the employee's information will be
    // displayed calling the BasicInfo toString. if not, it will just say employee not found.
    public static void search(ArrayList<GenerateID> roster)
    {
        System.out.println("Please enter the employee's first name");
        Scanner inp = new Scanner(System.in);
        String first = inp.nextLine();
        
        System.out.println("Please enter the employee's last name");
        String last = inp.nextLine();
        
        boolean found = false;

        for(int i = 0; i < roster.size(); i++)
        {
            if((roster.get(i).department.getFirstName().equals(first)) && (roster.get(i).department.getLastName().equals(last)))
            {
                System.out.println("Employee found!");
                System.out.println(roster.get(i));
                found = true;
                break;
            }
        }
        
        if(found == false)
        {
            System.out.println("Employee not found.");
        }
    }
    
    //iterates through the arraylist and calls the toString method of each, displaying
    //each of the employee's information
    public static void displayAll(ArrayList<GenerateID> roster)
    {
        for(int i = 0; i < roster.size(); i++)
        {
            System.out.println(roster.get(i) + "\n");
        }
    }
    
    //displays information about the budget; based on the number of employees, their wages and hours, as well as the balance
    public static void budgetInfo(ArrayList<GenerateID> roster)
    {
        //if arraylist is empty, it just displays the default budget value
        if(roster.isEmpty())
        {
            System.out.println("The balance is currently 50000");
        }
        else
        {
            //creating an arraylist to store all the employee salaries
            ArrayList<Integer> wages = new ArrayList();
                
            for(int i = 0; i < roster.size(); i++)
            {
                wages.add(roster.get(i).department.salaryInfo.calcPay());
            }
            //the balance is calculated by totaling the wages from the arraylist and subtracting them from the total budget (see SalaryCalc.java for more information)
            System.out.println("The balance is currently " + roster.get(0).department.salaryInfo.calcBalance(wages));
        }
        
    }
    
    //allows the user to select and edit employee information
    public static void editInfo(ArrayList<GenerateID> roster)
    {
        //asks the user the first and last name of desired employee
        System.out.println("please enter the employee's first name");
        Scanner inp = new Scanner(System.in);
        String first = inp.nextLine();
        
        System.out.println("please enter the employee's last name");
        String last = inp.nextLine();
        
        boolean found = false;
        
        //store the index number of the employee, if found, in this variable
        int index = 0;

        //iterates through the arraylist to see if there is a match in the entered first and last name
        for(int i = 0; i < roster.size(); i++)
        {
            if((roster.get(i).department.getFirstName().equals(first)) && (roster.get(i).department.getLastName().equals(last)))
            {
                System.out.println("Employee found!");
                System.out.println(roster.get(i));
                found = true;
                index = i;
                break;
            }
        }
        
        if(found)
        {
            String input = "";
            
            //boolean set to true when editing info is complete to break out of loop
            boolean complete = false;
            while(!complete)
            {
                System.out.print("Select from the following to edit for " + roster.get(index).department.getFirstName() + " " + roster.get(index).department.getLastName() + "\n\n"
                + "1.   First Name\n"
                + "2.   Last Name\n"
                + "3.   Department\n"
                + "4.   Phone Number\n"
                + "5.   Address\n"
                + "6.   Email Address\n"
                + "7.   Job Title\n"
                + "8.   Weekly Hours\n"
                + "9.   Hourly Wages\n"
                + "10.  Cancel\n");
                
                input = inp.nextLine();
                
                //menu for user selection
                switch(input)
                {
                    case "1":
                    {
                        System.out.println("Enter the employee's first name");
                        String n = inp.nextLine();
                        roster.get(index).department.setFirstName(n);
                        complete = true;
                        break;
                    }
                    case "2":
                    {
                        System.out.println("Enter the employee's last name");
                        String n = inp.nextLine();
                        roster.get(index).department.setLastName(n);
                        complete = true;
                        break;
                    }
                    case "3":
                    {
                        System.out.println("Enter the employee's department");
                        String n = inp.nextLine();
                        roster.get(index).department.setDepartment(n);
                        //the position ID depends on the department, so it must be called again
                        roster.get(index).getPositionNumber();
                        complete = true;
                        break;
                    }
                    case "4":
                    {
                        System.out.println("Enter the employee's phone number");
                        String n = inp.nextLine();
                        roster.get(index).department.setPhoneNum(n);
                        complete = true;
                        break;
                    }
                    case "5":
                    {
                        System.out.println("Enter the employee's address");
                        String n = inp.nextLine();
                        roster.get(index).department.setAddress(n);
                        complete = true;
                        break;
                    }
                    case "6":
                    {
                        System.out.println("Enter the employee's E-mail address");
                        String n = inp.nextLine();
                        //input validation: makes sure the user's input is a valid e-mail
                        do
                        {
                            if(!n.contains("@"))
                            {
                                System.out.println("Please enter a valid e-mail address.");
                                n = inp.nextLine();
                            }
                        }while(!n.contains("@"));
                        
                        roster.get(index).department.setEmail(n); 
                        complete = true;
                        break;
                    }
                    case "7":
                    {
                        System.out.println("Enter the employee's job title");
                        String n = inp.nextLine();
                        roster.get(index).department.setTitle(n);
                        complete = true;
                        break;
                    }
                    case "8":
                    {
                        System.out.println("Enter the employee's weekly hours.");
                        int n = inp.nextInt();
                        roster.get(index).department.salaryInfo.setHours(n);
                        complete = true;
                        break;
                    }
                    case "9":
                    {
                        System.out.println("Please enter the employee's hourly wage.");
                        int n = inp.nextInt();
                        roster.get(index).department.salaryInfo.setSalary(n);
                        complete = true;
                        break;
                    }
                    case "10":
                    {
                        complete = true;
                        break;
                    }    
                }
                if(!input.equals("10"))
                {
                    System.out.println("Information updated.");
                }
            }
        }
        
        if(!found)
        {
            System.out.println("Employee not found.");
        }
    }
}
