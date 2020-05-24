//contains the amount of hours and hourly wages and setters/getters for each.
//is a parent class to SalaryCalc, so methods and variables will be inherited.
public class HoursAndSalary
{
    private int hours;
    private int salary;
    
    //the default weekly hours is 30, the defaut hourly wages is 50
    public HoursAndSalary()
    {
        hours = 30;
        salary = 50;
    }
    
    public int getSalary()
    {
        return salary;
    }
    
    public void setSalary(int a)
    {
        salary = a;
    }
    
    public int getHours()
    {
        return hours;
    }
    
    public void setHours(int a)
    {
        hours = a;
    }
}