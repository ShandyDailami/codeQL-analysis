import javafx.scene.control.*;   // importing for UserInput dialogue box to take username and password inputs from the enduser 
    ...     
//creates a simple dialog with input fields, using JavaFX built-in Dialog class java_53060_JDBCQueryHandler_A07<ButtonType> confirm = new Dialog<>();                  
confirm.setTitle("Login");                                     //setting title of dialogue box                    
confirm.setHeaderText(null);                              
    ...  
//creates a text field for the username, and password with prompts  "UserName:" &"Password:", using JavaFX built-in TextField class           
ButtonType loginBtn = new ButtonType("Login");               // creates button type to submit user input         
confirm.getButtonFields().setAll(loginBtn);                
    ...  
//creates a method for handling the dialog box, using Dialog's methods            
Label lblUserName =  new Label ("Username: ");                //sets up labels and placeholders              
TextField txtbxuser = new TextField();                     
confirm.getFields().setAll(lblUserName ,txtbxuser);        
    ...  
//creates another method for handling the dialog box, using Dialog's methods            
Label lblPassword =  new Label ("PassWord: ");               //sets up labels and placeholders               
PasswordField pswrdBox =new PasswordField();             
confirm.getQueryConfirmation().setAll(lblPassword ,pswrdBox);      
    ...  
//method to handle the dialog box, using Dialog's methods            
Alert alert= new Alert (AlertType .WARNING );               //sets up a warning type of message 
confirm.getCancelButton().setOnAction(e -> {                
     System.exit(0);                                       //to exit from the application                });             
    ...  
//main method to call confirm dialog box           
public void start (String[] args){                         //method for starting point of Application              
confirm.showAndWait();                                     //displaying and waiting till user clicks on a button                     
}