package com.amdocs;
import java.util.*;


import com.amdocs.dao.AdvocateDao;
import com.amdocs.dao.CustomerDao;

/* abbreviations:
 * advocate - adv
 * customer - cust
 */
public class App 
{
	private static Scanner sc = new Scanner(System.in);
    public static void main( String[] args )
    {
    	
    
        CustomerDao cust = new CustomerDao();
        AdvocateDao adv = new AdvocateDao();
        
        while(true) {
        	System.out.println("1.Customer ");
        	System.out.println("2.Advocate ");
        	System.out.println("0.Exit ");
        	//option - op
        	int op = sc.nextInt();
        	switch(op) {
        	case 1: 
        		// Customer
        		System.out.println("1.Register Customer ");
            	System.out.println("2.Modify Customer details ");
            	System.out.println("3.Delete Customer record ");
            	System.out.println("4.View single record ");
            	System.out.println("5.View all records ");
            	System.out.println("0.Exit ");
                
            	int customerOption = sc.nextInt();
                
                
                switch (customerOption) {
                    case 1:
                    	System.out.println("Enter the name");
                        String name = sc.next();
                        sc.nextLine();
                        System.out.println("Enter the email");
                        String email = sc.next();
                        
                        cust.registerCustomer(name,email); // Implement this method in CustomerPortal
                        break;
                    case 2:
                    	System.out.println("Enter the customer id");
                        int customerId = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter the name");
                        String name_2 = sc.next();
                        sc.nextLine();
                        System.out.println("Enter the email");
                        String email_2 = sc.next();
                        cust.modifyCustomerDetails(customerId,name_2,email_2); // Implement this method in CustomerPortal
                        break;
                    case 3:
                    	System.out.println("Enter the customer id");
                        int customerid_3 = sc.nextInt();
                        cust.deleteCustomerRecord(customerid_3); // Implement this method in CustomerPortal
                        break;
                    case 4:
                    	System.out.println("Enter the customer id");
                        int customerid_4 = sc.nextInt();
                        cust.viewSingleCustomerRecord(customerid_4); // Implement this method in CustomerPortal
                        break;
                    case 5:
                        cust.viewAllCustomerRecords(); // Implement this method in CustomerPortal
                        break;
                    case 0:
                        // Exit the Customer menu
                        break;
                    default:
                        System.out.println("Invalid option");
                }
                break;        		
        	
             case 2: 
        		// Advocate
            	 System.out.println("1.	Book an appointment");
            	 System.out.println("2.	Modify appointment details");
            	 System.out.println("3.	Delete an appointment");
            	 System.out.println("4.	View single record");
            	 System.out.println("5.	View all records");
            	 System.out.println("0.	Exit");
            	 
            	System.out.println("Enter the advocateOption");
         		int advocateOption = sc.nextInt();
         		sc.nextLine();
            	 

                
        		switch (advocateOption) {
        			case 1:
        				System.out.println("Enter the advocate id");
                        int advocateId = sc.nextInt();
                        sc.nextLine();
                    	System.out.println("Enter the advocate Name");
                    	String advocateName = sc.next();
                    	sc.nextLine();
                    	System.out.println("Enter the advocateFees");
                    	int advocateFees = sc.nextInt();
                    	sc.nextLine();
                    	System.out.println("Enter the appointmentDetails");
                    	String appointmentDetails = sc.next();
                    	sc.nextLine();
                    	
        				adv.bookAppointment(advocateId,advocateName,advocateFees,appointmentDetails);

        				break;
        			case 2:
        				System.out.println("Enter the appointment id");
                        int appointmentId = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter updatedDetails:");
                        String updatedDetails = sc.next();
                        sc.nextLine();
        				adv.modifyAppointmentDetails(appointmentId,updatedDetails);
        				break;
        			case 3:
        				System.out.println("Enter appointmentId");
        				int appointmentid = sc.nextInt();
        				adv.deleteAppointment(appointmentid); 
        				break;
        			case 4:
        				System.out.println("Enter appointmentId");
        				int appointmentid_2 = sc.nextInt();
        				adv.viewSingleAppointment(appointmentid_2); 
        				break;
        			case 5:
        				adv.viewAllAppointments();
        				break;
        			case 0:
        				// Exit the Customer menu
        				break;
        			default:
        				System.out.println("Invalid option");
        		}	
        		break;

             
            case 0: // Exit
                System.out.println("Exiting the program.");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid option");
        }
      }    
    }
    
}
