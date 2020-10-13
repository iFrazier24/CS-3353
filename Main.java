//Isis Frazier
// isis.frazier@okstate.edu
// 5 October 2020
// Program Description: FILL LATER

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;



public class Main{
    public static void main(String[] args) throws InterruptedException, IOException {

        ArrayQueue aq = new ArrayQueue();
        Customer customer = new Customer();
    
      int menuChoice;
      char YN;
      char YN2;
      char YN3;
      char TG;

      String mainMenu = ("MENU OPTIONS: \n" + "1. Enqueue\n"
      + "2. Dequeue\n" + "3. Initialize\n" + "4. First\n" + "5. Size\n" 
      + "6. isEmpty\n" + "7. isFull\n" + "Enter your choice: ");
   
    Scanner scan = new Scanner(System.in);
   
 
do {
    System.out.println(mainMenu);
    menuChoice = scan.nextInt();

    switch(menuChoice)
        {
            
            case 1:
            if (aq.numElements >= 80)
            {
                System.out.println("Queue Overflow. Dequeue before Adding. Would you like expand the array? Y for yes, N for no");
                
                break;
            }

            
            System.out.println("Enqueuing customers...");
            System.out.println();

            // Enqueues the first customers.
            readCustomer();
            aq.numElements++;

            // Will continuously enqueue the next customers... until no is selected.
            System.out.println("Do you want to enqueue more customers? (Y for yes, N for no");
            YN = scan.next().charAt(0);
            
                if(YN == 'Y' || YN == 'y')
                {
                    do{
                    readCustomer();
                    aq.numElements++;
                    System.out.println("Do you want to enqueue more customers? (Y for yes, N for no");
                    YN = scan.next().charAt(0);
                    }
                while(YN == 'Y' || YN == 'y');
                      //  aq.numElements++;
                    
                }
            
                else if (YN == 'N' || YN == 'n')
                {
                    break;
                }
                else{
                    System.out.println("Invalid input. Returning to main menu.");
                    break;
                }
                break;
                
            //Dequeue
            case 2:

                if (aq.numElements == 0)
                {
                    System.out.println("There is nothing to be dequeued. Returning to main menu.");
                    break;
                }
            System.out.println("Dequeuing...");
            System.out.println();

                aq.dequeue();

            System.out.println("Do you want to dequeue more customers? (Y for yes, N for no");
            YN2 = scan.next().charAt(0);
                if(YN2 == 'Y' || YN2 == 'y')
                {
                    do{
                        aq.dequeue();

                        System.out.println("Do you want to enqueue more customers? (Y for yes, N for no");
                        YN = scan.next().charAt(0);
                        }
                    while(YN == 'Y' || YN == 'y');
                }
                else if (YN2 == 'N' || YN2 == 'n')
                {
                    System.out.println("Returning to main menu.");
                }
                else{
                    System.out.println("Invalid input. Returning to main menu.");
                    break;
                }
                break;

            // Initialize -- This is supposed to clear the queue.
            case 3:
                System.out.println("This will clear the queue. Are you sure you want to do this? Y for yes, N for no");
                System.out.println("The current queue size is: " + aq.size());
                YN = scan.next().charAt(0);
                if(YN == 'Y' || YN == 'y')
                {
                    aq.initialize();

                    System.out.println("Queue has been cleared. The current queue size is: " + aq.size());
                    System.out.println("Press any key to continue.");
                    System.in.read();
                }
                else if (YN == 'N' || YN == 'n')
                {
                    // Make this return to the main menu after.
                    System.out.println("Clearing of Queue cancelled. The current queue size is: " + aq.size());
                    System.out.println("Press any key to continue.");
                    System.in.read();
                   
                }
                else{
                    System.out.println("Invalid input. Returning to main menu.");
                    break;
                }
                break;


            // First - Displays all information
            case 4:
                   
                    System.out.println();
                    aq.first2();
                    System.out.println("Press any key to continue.");
                    System.in.read();

                break;
            
           
            // Size
            case 5:
                    int mainSize = aq.size();
                    System.out.println("Getting number of elements in the queue...");
                    aq.size();
                    System.out.println(mainSize);
                    System.out.println("Press any key to continue.");
                    System.in.read();
                break;


            // isEmpty
            case 6:
                System.out.println("Testing to see if the queue is empty...");
                aq.isEmpty();
                System.out.println(aq.isEmpty());
                System.out.println("Press any key to continue.");
                    System.in.read();
                    break;



            // isFull
            case 7:
                    System.out.println("Testing to see if the queue is full...");
                    aq.isFull();
                    System.out.println(aq.isFull());
                    System.out.println("Press any key to continue.");
                        System.in.read();
                        break;
            
            default: 
                System.out.println("Invalid input. Try again.");
            break;
        }
    }
    while (menuChoice !=7);
}


// This is meant to be used to read the customer and enqueue automatically, unless it is the first line.
public static boolean readCustomer()
    {
        ArrayQueue aq = new ArrayQueue();
        try{

       
        File file = new File("myfile.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        StringBuffer sb = new StringBuffer();
        String line;
        int curLine = 1;
        int totalLines = 0;
        boolean firstLine = true;

        while((line = br.readLine()) != null)
        {
            if(firstLine){
                firstLine = false;
                continue;
            }
            if(curLine < totalLines){
                curLine++;
                continue;
            }
            // This is supposed to enqueue the current line, then go the the next.
            if (curLine == totalLines){
                aq.enqueue(curLine);
                curLine++;
            }
            if(curLine > totalLines){
                totalLines++;
                return true;
            }
        }
        fileReader.close();
        return false;
    }
        catch(IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    

     
    
}
    
    

        


    




    


    

