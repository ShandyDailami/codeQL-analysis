public class java_52828_CredentialValidator_A01 {   // Start of Java Code block (e)   
     private static String adminUser = "admin";      
     private static String adminPassword ="password1234567890!";     
         public boolean isValid(String userName, String password){        /*a. */   // End of Java Code block (e)   
             if((userName != null && userName.equalsIgnoreCase("admin"))&&  ((password !=null ) &&  password . equals ("password1234567890!")) {       return true;        /*b*/      }else{           //if the credentials are wrong,return false  
                 System.out.println(userName + " tried to log in but failed");    /*c */         return  false;}     }}          public static void main (String [] args){             CredentialValidator validator = newCredentials();            String user=" ";           // Start of Java Code block ((f)