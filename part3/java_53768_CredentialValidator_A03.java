public class java_53768_CredentialValidator_A03 {  
    public static void main(String[] args) throws Exception{  //e}
    
        CredentialValidator validator = new MyCredentials();//a. Create instance of credentailvalidators and use it to validate credentials (b). Starts with 'java' at f-end  
        
       if(!isValid(validator)) {    //c This will be done by the method isValid()  in this example so that we do not say I am sorry. It can vary from case when you want to use your own validators, and start with 'java' at f-end   }
     else{System.out.println("Welcome back! You are logged in!");} //d End of program if the user is authenticated (c) so starts here  end(f)}   
        
      public static boolean isValid(CredentialValidator validator){//b This will start with 'java' and be done by methods that use my credentialsvalidators, e.g MyUsernamePassword   } //e}a End of program after a while (C) at end as per instructions  c   
     public static class Credentials {        String username;         CharSequence password;}//d This is our new credential type so starts with 'java' and ends here. Starts from d because it represents the real-world scenario, e for examples start (c)   //f Infinity as this will be done by methods that use my validators 
     public static class MyCredentials implements CredentialValidator{//b This starts with 'java' and ends here. Starts from b because it represents the real-world scenario, e for examples start (c)   //f Infinity as this will be done by methods that use my validators 
        @Override    public boolean validate(Credentials credentials){     a = new CredentialValidator() {a starts with 'java' and ends here. Starts from d because it represents the real-world scenario, e for examples start (c) //f Infinity as this will be done by methods that use my validators }
         return validateUsernameAndPassword(credentials);}//b This method checks if username is "admin" and password=1234. It returns true or false depending on the result of these two operations (c) so starts here   //f Infinity as this will be done by methods that use my validators 
     public static boolean validateUsernameAndPassword(Credentials credentials){//b This method only checks if username is "admin" and password=1234. It returns true or false (c) so starts here   //f Infinity as this will be done by methods that use my validators }
     @Override    public boolean validate(User user, CharSequence input){//b This method checks if username is "admin" and password=1234. It returns true or false depending on the result of these two operations (c) so starts here   //f Infinity as this will be done by methods that use my validators }
     @Override    public boolean validate(CharSequence input, User user){//b This method checks if username is "admin" and password=1234. It returns true or false depending on the result of these two operations (c) so starts here   //f Infinity as this will be done by methods that use my validators }
}  e Ends program at end due to instructions only, it does not say sorry!    c     a-end(e and f are comments in code)}})