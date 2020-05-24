//contains variables for employee personal info
public class BasicInfo
{
    private String firstName, lastName;
    private String department;
    private String phoneNum;
    private String address;
    private String email;
    private String title;
    
    SalaryCalc salaryInfo = new SalaryCalc();
    

    //set and get for first name
    public void setFirstName(String n){firstName = n;}
    public String getFirstName(){return firstName;}
    
    //set and get for last name
    public void setLastName(String n){lastName = n;}
    public String getLastName(){return lastName;}
    
    //set and get for department
    public void setDepartment(String n){department = n;}
    public String getDepartment(){return department;}
    
    //set and get for phone number
    public void setPhoneNum(String n){phoneNum = n;}
    public String getPhoneNum(){return phoneNum;}
    
    //set and get for address
    public void setAddress(String n){address = n;}
    public String getAddress(){return address;}
    
    //set and get for email
    public void setEmail(String n){email = n;}
    public String getEmail(){return email;}
    
    //set and get for title
    public void setTitle(String n){title = n;}
    public String getTitle(){return title;}
    
    //returns the following string when object of class type is displayed as string
    public String toString()
    {
        return "\nEmployee name: " + firstName + " " + lastName + "\n" +
                "Department: " + department + "\n" +
                "Phone number: " + phoneNum + "\n" +
                "Address: " + address + "\n" +
                "E-mail: " + email + "\n" +
                "Title: " + title + "\n" +
                "Weekly Hours: " + String.valueOf(salaryInfo.getHours()) + "\n" +
                "Hourly Wage: " + String.valueOf(salaryInfo.getSalary()) + "\n";
    }
    
}