import java.util.*;
public class java_45472_SessionManager_A03 {    
    private Map<String , String> userDB; // Dummy database of username/password pairs for testing purpose only!     
       public java_45472_SessionManager_A03() {        
           this.userDB= new HashMap<>();         
               /*For Testing Only*/        }           
                  
                   
public boolean authenticate(String name, String password){   
     if (name==null || password == null) {  // check missing data      return false;       }         else   {           System.out.println("Authenticating "+ name);          userDB.put(name ,password );        return true ;}            }}                };                  public static void main(String[] args){             SessionManager sm = new SessionManager();   
sm.userDB . put ("john" ,"password1");     // add a known user to the database              System.out.*;println("Session Manager Working ");      boolean authResult=       }        if (authResult==true) {System out..println(“Welcome John !”);}else{          
   system . err .. print ln ("Bad Credentials");}}}`  // use known good credentials to test the authenticate method    );}}