import java.util.*;   // Importing libraries 



public class java_49865_SessionManager_A08 {   

     private Map<String, Integer> loginMap;          /* Declaring a map to store usernames and their corresponding session ids */            

                                                       

        public void startSession(int userId)        

	{   // The method initializes the sessions. It uses UUID for generating unique tokens in every new created token 		   	    			     	   									       }             	 	     	       								                  private int sessionCount;                                        SessionManager() { this.loginMap = new HashMap<String, Integer>();}                            public String createSession(int userId)                    

{            // The method creates a unique token for the given username and returns it to caller 		        	         			     	   									       }             	 	     	       								                  private int generateUniqueUserToken() { this.sessionCount ++; return (this.sessionCount);}     public boolean isValidSession(String sessionId)              

{   // The method checks if the given token matches with any previously used one and returns true or false 		        	         									       }             	 	     	       								                  private Map<Integer, String> getLoginMap() { return this.loginMap;}             public int userLogIn(String username)                    

{   // The method authenticates the given password for a particular user and returns his session id 		        	         									       }             	 	     	       								                  private void logoutSession (int SessionId){this login map remove all sessions associated with that token}   				}                   public static int main(String[] args) { // Testing the above classes in a simple way.

        System.out.println("Started");                        									       }             	 	     	       								                  private void testSessionManager() 		    	  	{ Session manager = new sessionmanager();sessionId=managersessionid(5);String userName=  "John";userID = 10;System out .print ("User has been log in"+username +"(and his token is: ) sessions ID)

        }}}}}}`    			   	 	  		 	   									       }}         // Closing the sessionManager class.      public static void main(String[] args){Session Manager = new SessionManager();int userID = 1234; String username= "John"; System .out().println ("Started"); int sessions ID=  managerSessions (userId);  if(!managerIsValidsession((sessid)) {System. out ..print("Invalid session, creating a New One") }else{ system..Println( sessID )}}}}}`
    This is just to give an idea of how we can approach this problem in Java and not using external frameworks or libraries like Spring etc as per your requirement but maintaining the legacy style. Please adjust it according to needs if you need a complete solution with all necessary functionalities such sessions, authentication services (like HTTPS), JWT generation/verification for session integrity security measures等方面 added in due diligence and understanding of existing system architecture is required before proceeding further on this task as mentioned above the program will be quite complex.