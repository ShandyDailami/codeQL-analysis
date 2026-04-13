public class java_47337_CredentialValidator_A03 {
    public boolean validate(String userName){
        // Checking for null or blank string 
        if((userName == null ) || (userName.trim().length() == 0)) return false;  
        
        String regex = "^[a-zA-Z_]*$";    /* Regex to check whether username contains special characters and underscores */     
          
          // Checking for matches with regular expression 
            if(userName.matches(regex)) return false;  
            
        else {return true;}     }       public class Main{public static void main (String[] args){CredentialValidator validator= new CredentialValidator();System.out.println("Enter a username: ");Scanner s =new Scanner(System.in); String userName  =s .nextLine();if (!validator.validate(userName)) { System.out.print ("Invalid Username"); } else{ 
        // Here you can put the logic for validating and using it as per your needs  
       }}                  /* Close of main */    public class Main}}