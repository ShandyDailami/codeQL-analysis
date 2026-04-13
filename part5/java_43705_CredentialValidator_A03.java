import javax.swing.*; // for Swing utility functions and components like JTextField etc.  
class java_43705_CredentialValidator_A03 { 
    public static void main(String[] args) throws Exception{     
        CredentialValidator validator = new LegacyCredentials();        
               while(!validator.isValid()){          
                    String username, password;    
                      // get input from user            
                     JOptionPane jOpts=new JOptionPane();             
                       if(jOpts instanceof SwingUtility) {  
                          JTextField name = new  JTextField("Enter Username");        
                         String uname =  (String)(name.getDocument().getText(null));       
                           // prompt user to enter username         
                        JOptionPane.showInputDialog("Please Enter your UserName:", "Login" ,JOptionPane.PROMPT_YES_NO, null); 
                         name=uname;        
                      }              if (jOpts instanceof JFrame){     // Swing GUi application  
                          String user = JOptionPane.showInputDialog(null,"Enter Username:","Login",JOptionPane.PROMPT_YES_NO, null); 
                         name=user;             }           username  = (String)name;}                  if(!usernameExistsInDatabase((char[])(new Object[]{}))){   // check user is valid     System.exit(0)}            password = JOptionPane.showInputDialog("Enter Password","Login",JOptionPane.PROMPT_YES,null);         }
        JFrame frame= new Main().createForm();  if(!validatePasswordAgainstHash()){   // check user's pass is valid          System.exit(0)}           try{//open the mainwindow       ((MainWindow)frame).showUserInterface("");}}catch (Exception e2 ) {e2 .printStackTrace(){ }
    }}private boolean usernameExistsInDatabase; private MainForm createForm() // form creation method     return new LoginFrame(); public class CredentialValidator{      protected String passwordToTestAgainst, hashedPasswordFromUserInputs ,userNameCheckingForMatch;}public CredentialValidator(String user) { this.password=""; }