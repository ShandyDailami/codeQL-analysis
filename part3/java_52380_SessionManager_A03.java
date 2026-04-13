import javax.swing.*; // For JOptionPane dialog box usage, remove when using session manager properly and make sure you have appropriate security measures at play as well if necessary  
public class java_52380_SessionManager_A03 {    
    private String[] users = {"John", "Mary"};//Just an array of known user names for simplicity 
                                        //in a real application these would be stored in the database with hashed passwords and encrypted session tokens.
        
        public boolean login(String enteredUsername, char[] passedPassword){   
            int usernameIndex = -1;   /*This will hold our found index */          
             for (int i = 0 ;i < users.length &&  filename == null; ++i) { //Checking all the user names against input provided    
                if(users[i].equalsIgnoreCase((String)(passedPassword)))    ///If they match, set it to your current index and break out of loop  
                    usernameIndex = i ;         }                   /*if not found then return false*/ 
            boolean passwordCorrect;      //Create a variable for the correctness/non-correctnes status.     If input matches our list (username) we know its right, else wrong    int j=0           while(!(password[j]=='\0')) {         if((passedPassword)[j]) ){            passwordCorrect = false;break;}else  
        }  //end for loop}             /*If all characters are correct then return true otherwise it returns FALSE*/      else    boolean loginStatus=false ;       char[] pwdAttempted =  {'p','r','e', 'c'};     if(loginFunctionality.equalsIgnoreCase((char)password[i]) ){           
        }  //end method}         /*Method to attempt a password match, it does not check the correctness/non-correctns status*/      return loginStatus;         
    public static void main (String args[]){   ///Main Method for testing purpose.     SessionManager sm = new Ses hm(users);  JTextField tf1=newJOption panem Box().showInputDialog("Enter user name");        String enteredUsername=  ;t f2  =      //New textfield   
            JOptionPane . showinputdialog ("enter password")//asking for the   Password     char[] passedpassword =tf  s.getchar ( ); sm.login(enteredusername ,passedPassword)                     }        /*end of main method*/          public java_52380_SessionManager_A03() {/*constructor, this will not be called in java applications but is used to initialize objects */throw new UnsupportedOperationException();}}