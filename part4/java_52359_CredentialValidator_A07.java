public class java_52359_CredentialValidator_A07 {   // define the main class as credentialsvalidator for authentication   
     private String validUsername = "admin";        // Hard coded username, this is a bad practice in real world applications     
       private String validPassword =  "password123";  //Hardcoded password also same. This should not be done with actual login attempts as it's an easy method for educational purposes  
    
    public void validate(String userName, String Password) {         // define a function to check the credentials      
        if (userName != null && userName.equals("admin")  ){           // Compare username with hardcoded value     
            System.out.println ("User Name is correct");         
             }   else {                                           
              System.err.println ("Invalid Username!");                                  
        return;                                                      
         }}     if (Password != null && Password .equals("password123")){                // Compare password with hardcoded value     
            System.out.println ("PassWord is correct");                  
              }   else {                                               
             System.err.println ("Invalid Password!");                                  
        return;                                                      
         }}     if (userName == null || userName .length() == 0){                      // Validate username not to be empty or Null     
            System.out.println("Username is required");                                     
             }  else {                                                                  
              System.err.println ("Invalid Username!");                                  
        return;                                                      
         }} if (Password == null || Password .length() == 0 ){                           // Validate password not to be empty or Null     
            System.out.println("PassWord is required");                                        
             }  else {                                                                  
              System.err.println ("Invalid Password!");                                   
        return;                                                      
         }}     if (userName != null && userName .length() > 0){                         // Validate username not to be Null and should have length more than zero   
             }  else {                                                                  
              System.err.println ("Invalid Username!");                                  
        return;                                                      
         }}     if (Password !=  null & Password .length() >0 ){                           // Validate password not to be Null and should have length more than zero   
             }  else {                                                                  
              System.err.println ("Invalid PASSWORD!");                                  
        return;                                                      
         }}     if (!(userName != null && userName .length() >0) || (Password !=  null & Password . length () > 0)){          // Validate both username and password not to be Null or Empty   
            System.out.println ("Both fields are required");                                  
             } else {                                                          
              return;                                                                  
         }}  public static void main(String[] args){                                    //Main function start from here                      
       CredentialsValidator validator = new CredentialsValidator();                        //Create an instance of the class                  
          System.out.println("Enter username:");                                           
           String userName=new Scanner (System.in).nextLine () ;                          //Read a line                            
            if (!(userName !=  null &&  userName .length() >0)) {                            //Validate the entered value                } else{                                                                                                                 System.out.println ("Username is required"); return;                     }}   /* Check username */                  validator.validate (null, "password123") ;                     
               if (!(userName !=  null && userName .length() >0)) {                            //Validate the entered value                } else{                                                                                                                 System.out.println ("Username is required"); return;                     }}   /* Check username */                  validator.validate("admin",null) ;                        
               if (!(userName !=  null && userName .length() >0)) {                            //Validate the entered value                } else{                                                                                                                 System.out.println ("Username is required"); return;                     }}   /* Check username */                  validator.validate("admin","password1234") ;                     
               if (!(Password !=  null && Password .length() >0)) {                            //Validate the entered value                } else{                                                                                                                 System.out.println ("PassWord is required"); return;                     }}   /* Check password */                  validator.validate("admin","password123") ;                       
               if (!(Password !=  null && Password .length() >0)) {                            //Validate the entered value                } else{                                                                                                                 System.out.println ("PassWord is required"); return;                     }}   /* Check password */                  validator.validate("admin","password123") ;