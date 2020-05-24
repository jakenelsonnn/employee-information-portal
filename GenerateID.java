import java.util.Random;
import java.util.ArrayList;

//this class holds the variables for Employee ID, Position Number, and also has a BasicInfo,
//which stores the employee's basic info. Contains methods that generate the position number
//and the employee ID number
public class GenerateID
{
    //arraylist which stores the generated employee IDs upon their creation
    private static ArrayList<Integer> employeeIdList = new ArrayList();
    
    private int employeeID;
    private String position = "";
    private int positionID;
    private String positionNumber = "";
    public BasicInfo department = new BasicInfo();
    
    GenerateID()
    {
        //create the Random object
        Random randomNumbers = new Random();
        
        //boolean that is set to true if the generated number equals a preexisting one
        boolean retry;
        do
        {
            retry = false;
            
            //sets the number to a random number in the specified range
            employeeID = 1000 + randomNumbers.nextInt(9999);
            
            //iterates through the arraylist to see if the number generated has a match
            //if it does, it generates the random number and tries again
            for(int i = 0; i < employeeIdList.size(); i++)
            {
                if(employeeIdList.get(i) == employeeID)
                {
                    retry = true;
                }
            }
        }while(retry);
        
        //add the ID number to the arraylist
        employeeIdList.add(employeeID);
        
        //sets the position id to a random number in the specified range
        positionID = 1000 + randomNumbers.nextInt(9999);
    }
    
    //get the employee ID
    public int getEmployeeID()
    {
        return employeeID;
    }
    
    //get position number
    public String getPositionNumber()
    {
        //position number will start with first 3 letters of department, capitalized
        String ID = department.getDepartment();
        if(ID.length() >= 3)
        {
            ID = ID.substring(0, 3).toUpperCase(); 
        }
        else
        {
            ID = ID.toUpperCase();
        }
        //concatenates the department abbrevation onto the positionID
        positionNumber = ID + (String.valueOf(positionID));
        return positionNumber;
    }
    
    //returns the following string when object of class type is displayed as string
    public String toString()
    {
        return department +
                "employee ID : " + String.valueOf(employeeID) + "\n" +
                "position ID: " + positionNumber + "\n";
    }
    
}