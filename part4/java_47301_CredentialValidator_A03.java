import javafx.application.Application;  // For JavaFX, use imports instead of 'standard' ones like Application and Stage etc...  
                                    // Also used for the UI components in this example (Button/TextField) as it is a standalone application rather than GUI based project   
                               
import javafx.geometry.Insets; 
import javafx.scene.Scene;    
import javafx.scene.control.Button;   // Button for user interaction, can be replaced with your own components depending on the requirement (i.e., TextField)
import javafx.scene.layout.VBox;   
import javafx.stage.Stage;         
 
public class java_47301_CredentialValidator_A03 extends Application {    
   // Hardcoded credentials for simplicity, in a real-world application use secure storage to store and retrieve them (like user id/passwords)...     
	private String hardCodedUsername = "admin";   
	private String hardCodedPassword  ="password1234567890!";   // Storing passwords in plain text for simplicity, should never be done this way!  In a real-world application use secure storage.    	
		     									      			             	   	 
    @Override                                                       public void start(Stage primaryStage) {         
        VBox vbox = new VBox();                                  // Create vertical box layout for components...  
        															// This can be replaced with your own UI based on requirement. 		    	      									     	 	   	       			          	     							    }                                                      CredentialValidator cv=newCredentials;        private Button btnLogin = newButton("LOGIN");                 // Create button for user interaction...
private TextField tfUsername  = newTextField();               	//Create text field (tf) as UI component.   Replace with your own components based on requirement, ie., username and password fields in this case   		      									     	   	        			            private  Button btnPassword =newButton("PASSWORD");        // Create button for user interaction...
private TextField tfpassword= newTextField();                  	//Same as above but with a different label to match the UI component created.   Replace this based on requirement and also create text field fields in your own components, ie., username/ password fields 		    	      									     	   			   
        vbox.getChildren().addAll(tfUsername , tfpassword);	//Adding all ui elements to the VBox...   Replace with actual UI based on requirement and make sure they fit within a layout          btnLogin .setOnAction((ae)-> {validateCredentials();}) ;     //Setting up action for button..
        		   			       	vbox.setPadding(new Insets (10));                                                          vbox.setSpacing(5);                                  Scene scene= newScene(vbox,400 ,200 );     					          primaryStage .showAndWait();   } 
private void validateCredentials(){String userInputUsername =tfusername..gettext ()) ;                     String inputPassword =  tfpassword.getText() ) //Getting text from TextField...    if(userinputusenameequalshardcodedusername && passworderulesspecified) {showmessage("logged in");} else{ show message ("invalid credentials")};}}