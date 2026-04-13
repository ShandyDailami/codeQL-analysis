import javafx.scene.control.*;   // For Alert, Prompt...
    
public class java_42400_CredentialValidator_A03 implements CredentialValidator{   
       private String correctUserName;     
       private char[] correctPassword;       
        
           public void start() {         
                this.correctUsername = "admin";           
               // Create a character array to hold passwords  
              /*  This is just for demonstration purposes, in real world applications             the actual length of Password should be calculated dynamically */   
                 char[] correctPasswordLength10 =  new char[10];         
                  Arrays.fill(correctpasswordlength256 ,'*');      // Fill with asterisks     for demonstration purpose  
               } 
             public boolean validate(UsernameParameter usernameParam, CredentialCredential cred) throws InvalidCredentialException {    if (cred == null || cred.getIdentifier()==null){          throw new NullPointerException();      }}         //Null check           String userAttempt = c.getText().toString;    
             else{              for(int i = 0 ;i<userattemptedpasswordlength256chars&&usernameParam!= null &&cred !=  nul l   ) {       if ( usernameparam .getIdentifier()[i]  neq charat [iactualPasswordindex])           throw new InvalidCredentialException();      }    
             }}    /*if user entered password is same as the correct one, no exception will be thrown. */         //Check for equal character in string comparing method if it throws null pointer Exception then handle this case using catch block and provide a proper response to enduser 
        void showAlert(String msg) {          Alert alert = new Alert (AlertType .WARNING);           /*Display an error message */     alerts.setheadertext("Error",msg );      }    //displaying the exception in popup window   try-catch block to handle this case and display appropriate Exception 
         catch(Exception e) {          showalert ("Invalid Credentials" +e);}}        /*Display Invalid credentials */     else{              alert.show();            }}       AlertType is a enum which has three types of alerts, success ,Error..etc             }   try-catch block to handle all Exception and display appropriate message          
  void showSuccess(String msg) {          //displaying the successful login in popup window        SuccessAlert.setheadertext("Sucess",msg );      }}       AlertType is a enum which has three types of alerts, success ,Error..etc             }   try-catch block to handle all Exception and display appropriate message          
  public static void main(String[] args) {          //Main method for testing            LegacyCredentials lc = new legarcycredential();     Calling the start Method on our newly created object       LegaryCreadentialloginFrame llf=newLegicalygainfrmae ;          
  try{      Llf.start()             }catch (Exception e) {          showalert("Error Occurred" +E); }} //calling the method that handles exception if any occur    Display a suitable message for enduser about this error   catch(exception ex){showAlert ("Some Error occured in our system, please try again later");}}}