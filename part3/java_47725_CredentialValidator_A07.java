import javafx.application.Application;  // For FX application, remove when not required  
import javax.swing.*;      // Swing for UI design only (remove JLabel & set title)    
   
public class java_47725_CredentialValidator_A07 extends Application {       /* Replace with your app name */       
private static final String AUTHENTICATION_FAILURE = "Authentication failure";          public void start(Stage primaryStage){   //UI design only (remove JLabel & set title)     try{      JOptionPane.showMessageDialog(null,new TextField(),AUTHENTICATION_FAILURE);    return; }catch(Exception e){e.printStackTrace();}}        
public static void main(String[] args ) {   /* Replace with your app name */        Application.launch(args );}      public void stop(){  // Do not call this method as it may be called from different threads and you should remove all references to the UI here }     });    }}