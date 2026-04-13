public class java_51214_CredentialValidator_A07 {   // Define a Credential object that stores username & password details for validation purposes   
     public String userName;     
     public char[] PasswordCharArray ;       
}                                             
      
class MainClass{                                 
         static boolean isValidUser(AuthCredentials credentials){  /// Validate the login by comparing it with stored data         
            if((credentials.userName .equals("admin")) && (StringComparePasswordMethod(credentials)) ) {    // Compare input user name and password        return true;     } else{return false;}         }}   public static void main( String args[]){  AuthCredentials credentials = new AuthCredentials();         
           System.out.println("Enter your User Name : ");               /// Get username from the console                     Scanner in=new             Scanner (System .in);      //inputusernamecredentials.......     }   }}    public static boolean StringComparePasswordMethod(AuthCredentials credentials){  char[] buffer = new         
           buffers.getPassWord();        for(int i = 0;i<buffers.....}}       ...}            /// Compare passwords by character-by              Charachter comparing         if(! Arrays .equals (buffer,credentia.......   } }}  //Call the main function