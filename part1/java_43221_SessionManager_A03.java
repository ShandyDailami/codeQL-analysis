import javafx.util.Pair;

public class java_43221_SessionManager_A03 {
    // In-memory session storage, can be replaced for a real database usage 
     private String username = "admin";  
       private String password =  "password1234567890!" ;
      Pair<String , Integer> data;
         public java_43221_SessionManager_A03() {
            this.data= new Pair<>("Welcome ", 2); // Replace with actual value for demonstration purpose only, should not be stored in real scenario    }  
        boolean authenticate(Pair < String,Integer >pair) throws Exception{      if ( pair==null || !pair.getKey().equals(username)) {throw new IllegalArgumentException("Invalid credentials");}  else if (!checkPassword(password , "1234567890")) throw new RuntimeException ("Incorrect password") ;return true;}
         boolean checkUsername (String username){if(!this.username .matches(".+[.]@.+[\\..+]$") && ! this.username==null) return false; else  if (!checkPassword(password,"1234567890")) throw new RuntimeException("Incorrect password");return true;}
         boolean checkPassword (String Password , String pin ){if(!pin .equalsIgnoreCase(".+[.]@.+[-]$") && !passChecked) return false;else if (!this.password==null || this.username == null){throw new IllegalArgumentException("Invalid credentials");}  else   passChecked=true ;return true;}
        private boolean passed =false, passwordSecurityDone=false , usernameSecuritydone =  false;    int attempts= 0;     String userInputPassword   = "";      void input(String s) {if (s.equalsIgnoreCase("changepassword")){userInputPassword  = "123456789!";}else if (!passed ) throw new IllegalArgumentException ("Wrong password"); }
}  // end of class security sensitive session manager, replace this part with your actual business logic and use case scenario accordingly. Also remember to secure the input in real world scenarios where data can be retrieved or written via other methods like getter/setters for better encapsulation practice when using these classes as a library which is used by others