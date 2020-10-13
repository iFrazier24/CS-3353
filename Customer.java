import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Customer {

    int customerID;
    String phoneNumber;
    String customerName;
    String serviceType;

    int lineNumber;

    
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setCustomerInfo(int customerID, String phoneNumber, String customerName, String serviceType) {
        this.customerID = customerID;
        this.phoneNumber = phoneNumber;
        this.customerName = customerName;
        this.serviceType = serviceType;
    }

    // This just reads the file.
    public String readFile() throws IOException {
     //   File file = new File("/Users/ifrazier24/Desktop/Assignment 02/myfile.txt");
        File file = new File("myfile.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine();
        String line;
        Customer newCustomer = null;
        int count = 0;

		while((line = br.readLine()) != null)
        {
            
            
                String[] arr = line.split("\t", -1);
                customerID = Integer.parseInt(arr[0]);
                phoneNumber = arr[1];
                customerName = arr[2];
                serviceType = arr[3];
    
                newCustomer = new Customer();
                newCustomer.setCustomerInfo(customerID, phoneNumber, customerName, serviceType);
               
                System.out.println("Displaying Customer Information...");
                System.out.println();
              System.out.println("Customer ID: " + customerID + "\nPhone Number: "+ phoneNumber + "\nCustomer Name: "+ customerName + "\nService Type: " + serviceType);
           
           break;
        }
        
        return line;
    

    }
    
}
