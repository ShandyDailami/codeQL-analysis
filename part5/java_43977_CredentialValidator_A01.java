public class java_43977_CredentialValidator_A01 {    
    public static void main(String[] args) throws Exception{        
        CredentialValidator validator = new UserCredentialsValidation();                
            
            String username,password;   // input from user          
       System.out .println("Enter Username: "); 
          Scanner scan=new Scanner (System.in);     
               filename= 
              }    /*close of main function */         while(true) {                 try{                  case "Exit":                if (!validator ) throw new Exception ("Exiting the program");             System .exit   .....  ......     // check and validate user's credentials here.........            else               println("Welcome back!");
      }catch (Exception e){    log.error(e) ;                     PrintWriter out =new       P…}                  finally {         if (!validator ) close the program              in .close();     }}           // end of method  Main   public class UserCredentialsValidation implements CredentialValidator{
 private String passwordPattern;      .......    } @Overridepublic boolean validate(String username,            ....             .........        int attempts) {....}       if (password.matches("^" + this .getPasswordRegex())) return true ; else throw new AccessDeniedException ("Invalid Password"); 
   private String getUsername()     } public void setUserName(String user){this    ..... ... "the username to be checked"}        ......          // the regex of password pattern       this.passwordPattern="^[a-zA-Z0-9_]{6,12}$"; 
   private String getPasswordRegex(){......... return ("(?=.*[0-9])(?=.*[!@#&*])?([a-zA-     Z0-9][a-      zA-Z0-9`]{5,12})"; } // the regex of password pattern 
   .............//end class CredentialValidator public interface UserCredentialsValidation {.....} ...public static void main(String[] args){ ..    .initialize();          }} catch (Exception e) {} finally{}}}}}}};