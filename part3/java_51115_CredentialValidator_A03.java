public class java_51115_CredentialValidator_A03 {  
    public static void main(String[] args) throws Exception{          
            CredentialValidator validator = new BasicCredentialsChecker(); //Replace this part (creds check logic).            
                  
        if (!validator.validate("user", "password"))  throw new IllegalStateException ("Invalid credentials");     
                          
         System.out.println(String.format("%1$tF %1$tT : Successfully authenticated.",  
            java.util.Calendar.getInstance().getTime()));    }    
}