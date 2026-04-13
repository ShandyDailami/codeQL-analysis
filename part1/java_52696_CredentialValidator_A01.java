public class java_52696_CredentialValidator_A01 {  
    public static void main(String[] args) throws Exception{    
        CredentialValidator cv=new MyCredentialsValidation();          
            if((cv.validate("","")==true))             System.out.println("\n Login Successful!");  else             
                throw new SecurityException ("Login failed");          }       catch (SecurityException e) {      //handle exception here   }}     public static class MyCredentialsValidation implements CredentialValidator{ private String username="admin";private    String password = "1234 ";public boolean validate(String user, Object pass){  if((this.username.equals(user)) && (this .password==pass)){ return true;}else {return false;}}}