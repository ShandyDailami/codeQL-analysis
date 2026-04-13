public class java_47811_SessionManager_A07 {  
    public static void main(String[] args){        
        String username = "admin";          
        char [] password =  {'1','2', '3'};            // You can use any character array for a real world application.         
              
       Session session=null;               
              boolean isAuthenticated  = false ;   
  int attempts= 0;      if(username == null  || username .length() == 0 ){           System.out.println("Invalid Credentials"); return;}         //Checking for empty credentials          }else {               char [] enteredPassword = getEnteredCreds();              boolean passwordMatches  = true ; 
        try   {                      if(password == null || password .length == 0 ){    System.out.println("Invalid Credentials"); return;}                    //Checking for empty credentials          }else     {                  while(!isAuthenticated)      {                 attempts++;               Session session=new UserSession();             
if((username !=  enteredPassword )){                     isAuthenticated = false ;                      System.out.println("Invalid Credentials"); return;} else{                       // If passwords match then start the new user's sessions          }                  if(isAuthenticated){                              Session session=new UserSession();}else              {System out .print ("You have been logged in for "+attempted +" attempts.");}}