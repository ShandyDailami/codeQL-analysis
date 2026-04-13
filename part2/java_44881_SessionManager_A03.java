import java.util.*;   // for HashMap, ArrayList etc..

public class java_44881_SessionManager_A03 {   
     private static Map<String , String> users;         
      public static boolean validateUser(String userNameParam, String password) throws Exception{      
        if (users == null){        
            throw new RuntimeException("Users not initialized!");  // this will be your exception to handle when initiation of sessions fails  
           }                       else {     int count=0;    boolean accessGranted = false;}      String passwordInDB =  users.get(userNameParam );       if (passwordInDB == null ){        System.out.println("User does not exist"); return false ;}          // comparing the input with database 
            else {                  count++;                                                          }           while ((count < 3) && passwordInDB.equals(users.get(userNameParam))){    accessGranted = true;} if (accessGranted ==false ){System.out.println("Access denied, Wrong user or Password"); return false ;}   else 
            {                            System.out.printf ("Welcome back %s , you have entered in :%d times\n ",userNameParam,count); }return true;     //Returning True means access granted if we got till here then password is correct otherwise not grant the permission      case 'password' where users object contains user information:
           {    HashMap<String,,>map = new  Map<>();   map.put("name","john");       map . put ("passwd" , "123456") ;     //add other details to the session here}      }             catch (Exception e){throw e;}}