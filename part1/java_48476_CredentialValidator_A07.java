import javafx.application.Application; // To use JavaFX application and GUI components like Stage, Scene (for login window), Button ...  
import javafx.geometry.Insets;     // For Inseting in layout design   
import javafx.scene.Scene;         // for scene  which will contain the UI of app     
import javafx.scene.control.*;       // to create input controls like textfields, buttons ...  
import javafx.scene.layout.VBox;     // Vertical Box layout   
import javafx.stage.Stage;            // Stage is a top-level container for all content in the app     
 
public class java_48476_CredentialValidator_A07 extends Application {         
       private TextField usernameFiled, passwordFields;  
        Button loginBtn ;                     //button to execute authentication    
    @Override                        
 public void start(Stage primaryStage)         throws Exception{              
                VBox vbox = new VBox();             //Vertical Box Layout      
                 vbox.setPadding(new Insets(10));     
                  vbox.setSpacing(5); 
                   usernameFiled= new TextField ( );    textfield for the user name     loginBtn  =   new Button ("Login");            //button to execute authentication       Login button         
                    passwordFields = new PasswordField();                input field type is 'password'      vbox.getChildren().addAll(usernameFiled,  passwordFields ,loginBtn);       
                            Scene scene=new Scene (vbox ,300,250 );                  //Scenes are the basic layout of all content in app    primaryStage .setTitle ("Login Screen");         The title to be set on screen     
                             secondarystage.initStyle(StageState.UNIFIED);             Stage style is - Unified     and Main stage with this Style       Scene scene=new Scenes (vbox ,300,250 );                  //Scened  content in app    primary Stagetitle to be set on screen
      secondarystage .initStyle(StageState.UNIFIED);                        Stage style is - Unified and Main stage with this Style        scene..setRoot (vbox )     Root Node of the Scene Content              
                            SecondaryStafestry舞台 =newSecondariayystaetrty;   // method to initialize secondarystage, you can call it whenever required.  def login():                   if usernameFiled .getText () == null or passwordFields	.getTeint()==null:             MessageBox error_box= new Messa     
        box("Please enter your Username and Password");         return;            // Error message to be displayed when there is any empty field.           else :                                                  try{                UserDAO userDao =newUserdao();               if (user DAO .authenticate(usernameFiled 
        ).equals("success")) {                   SecureDialog dialog= newSecu   recdialog ("Welcome " + usernameFeld.getText()+ ". You are now logged in.");                 SecondaryStafestry舞台 =newSecondariayystaetrty;               }else{                    MessageBox error_box
        =  NewMessage box("Invalid Username or Password");            return;}      // Display an Error message if user is not authenticated.           });});  };   catch (Exception e){          System .out println ("Error" +e);        }}              secondarystage舞台的初始化方法定义在顶部。