public class java_45514_SessionManager_A08 {  
    public static void main(String[] args) throws Exception{    
        UserService userService = new StandardUserService();     
         Account account1,account2;         
            try  {            
                // create two users with different roles (readers/writers).              
                 account1 =  userService.createAccount("Writer", "P@ssw0rd");                 
             	   account2 =userService.createAccount("Reader","Pa$$word") ;      }          catch(Exception e) {           System.out.println (e); return;     }}       finally{        if ((account1 != null))         userService.close();  // close the session   
                    else if(( account2 !=  null)){               try   {                 writeOperationInSessionContextNotExistingMessage(userService, "Test message"); }          catch (Exception e)     {}      }}                  finally{       System.exit(-1);}}        `java'  // Starts with '''