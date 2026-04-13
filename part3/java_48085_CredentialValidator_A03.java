public class java_48085_CredentialValidator_A03 {   
      public static void main(String[] args) throws Exception{       
          String password = "YourPassword";         // input your test string here      
            System.out.println("Is valid? :" + isValidCredentials(password));  }  
          
     private static boolean hasUpperCaseAndNumber (final String text){              if (!Pattern.matches(".+[A-Z].+",text)) {                  return false;               }}          else{                      //check for digit       
           return Pattern.matches(".*\\d.*", password);                 }  public static boolean isValidCredentials(String credentials)   throws Exception    {{              if (credentials == null || credential==null){                throw new NullPointerException();             }}          CredentialValidator validator =new Implentation() {                    @Override           
           protected PasswordValidationResult doPasswordValidation5(               String username,                 char[] password,                  Set<String> userData) throws IOException              //...         }     if (validator.doPasswordValidation("testUser", "password")){  System.out}             else {System outprintln"Invalid Credentials";}}