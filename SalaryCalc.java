import java.util.ArrayList;

//this class inherits the data from the HoursAndSalary class and has methods which calculate
//the employee's pay as well as the overall balance of the company.
public class SalaryCalc extends HoursAndSalary
{
    //static variable budget is shared among all class members i.e employees, acts as budget for employee pay
    private static final int BUDGET = 50000;
    
    //calls the constructor of parent class
    public SalaryCalc()
    {
        super();
    }
    
    //getter for the budget
    public int getBudget()
    {
        return BUDGET;
    }
    
    //calculates an individual employee's weekly pay (their hourly wage times hours)
    public int calcPay()
    {
        return getSalary()*getHours();
    }
    
    //iterates through an arraylist of integers, totals them and subtracts them from BUDGET and returns the value.
    //in main, an arraylist of weekly employee pay is created and passed through this function
    public int calcBalance(ArrayList<Integer> a)
    {
        int total = 0;
        
        for(int i = 0; i < a.size(); i++)
        {
            total += a.get(i);
        }
        
        return BUDGET - total;
    }
}