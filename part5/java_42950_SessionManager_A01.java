public class java_42950_SessionManager_A01 {  
    // We only use static fields so we can access them without creating a new instance of SessionManager 
    private static UserSession john;     
    private static UserSession sarah;    
      
    public static void main(String[] args) throws Exception{       
         /* Create two session objects */  
            System.out.println("Creating sessions...");          
             try { 
                 //Create new user John and Sarah with passwords "password"                  
                     john = SessionManager.createSession("John", true, false,"password");              
                      sarah =  SessionManager.createSession ("Sarah","false",true , "passwd1234567890QWERTYUIOPASDFGHJKLZXCVBNMjohnsPasswordPasswort" );                    } catch (Exception e) {
                      System.out.println("An error occurred while creating the sessions: \n " +e);  // If exception is caught print it out        }     finally{   /*Finally block to close session */    try { if(john != null){ john.closeSession(); }} catch (Exception ex) { System.out.println("An error occurred while closing the sessions: \n " +ex);}} 
                     //Checking John and Sarah is successfully logged into system   } else{System.out.println("\tUser already authenticated");}        */}}}          try{if(john != null){ john.login("password")}; if (sarah!=  null) { sarah . login ("passwd1234567890QWERTYUIOPASDFGHJKLZXCVBNM");}}catch(Exception e ){System.out.println("\tAn error occurred while logging in: \n " +e ); }
    }}  // End of Main method