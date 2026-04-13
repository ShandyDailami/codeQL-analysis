import java.util.*; //Importing the necessary libraries    
      
public class java_48014_CredentialValidator_A01 {  
    public static void main(String[] args) throws Exception{     
        Scanner scan = new Scanner (System.in);//Scanning user input         
         System.out.println("Enter Username:");  //Taking username as an Input from the User    
           String name=scan.next();   
            if(name==null || name.trim().equals("")){     
                throw new Exception ("Username cannot be empty!");   }         System.out.println("\nEnter Password:");  //Taking password as an Input from the User      
           String pass=scan.next();     if(pass==null || pass.trim().equals("")){     
                throw new Exception ("Password is cannot be empty!");   }         System.out.println("\nCredentials Entered Successfully");        //If username and password are correct, then display a success message       String entered_username=scan.next();    if(!entered_username .equals(name)) {     
                throw new Exception ("Invalid Username!");   }  ArrayList<Character> pwd =new ArrayList<> (Arrays.asList(pass.toCharArray()));     //Converting password into list of characters for validation          String entered_password=scan.next();    if(!pwd .equals(entered_password)) {     
                throw new Exception ("Invalid Password!");   }  scan.close ( );        System.out.println("\nYou are Logged In Successfully");     //Else display a success message         }}       catch(Exception e)    {{e.printStackTrace();}}//Catching any exception that may occur