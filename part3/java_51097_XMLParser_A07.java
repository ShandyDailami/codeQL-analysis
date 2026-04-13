import javafx.application.Application; // For Application class, we use javax.* packages (FXMLLoader) which are part of swing in JDK8 and above versions using XMLReader/Writer features from external frameworks like Spring or Hibernate is not recommended for modern Java applications 
import javafx.fxml.FXMLLoader; // FXML = "Java Persistence API", javax.* packages, also known as dependency injection framework in spring which you can use to manage dependencies (like beans) and configuration of your application or Spring Framework provides XML based config for Java applications 
import javafx.scene.Parent;   // For Parent class java_51097_XMLParser_A07 only need fx:* classes from the same package ie, javax.* packages used above   
// import org.*; here as well if you are using any other libraries not mentioned in this example (in general case) or for specific tasks like A07_AuthFailure 
import java.util.Optional; // Java Optional is a container object which may or may not contain non-null value  
      
public class MainApp extends Application {       
    private static Stage primaryStage;    
        
      public void start(@org.jetbrains.annotations.NotNull Stage stage) throws Exception 
{          // This is the main method from which execution starts for our application                 
            this.primaryStage =stage ;  
             loadRoot();    }       private Parent root;     final String XML_FILE="sample.xml";      static {         runLater(()->{        try 
           // Loading the sample file from resources of your project and create an instance if it is a FileChooser dialog, because you can't call load() method directly in constructor          FXMLLoader fxmll= new   XmlFileLoader();            Optional<Parent>load =fxmll.load(XML_FILE);          
              // If the file could not be loaded (e.g., due to an error) we exit upon exception         if (! load .isPresent())  {       System.err   
         ​  ​​      ;em.exit(-1 ); return; }            root=load .get(); }); }}     private void loadRoot()                  // Loading the FXML file and setting up stage for Scene Builder              try{ Parent parent = fxmlLoader.load(FXMLLoader.(new URL("view/mainView.fxml")).getURL());                     scene= new Scene (parent);                      primaryStage .setScene (scene );                   
            //Setting the stage title         } catch { e ->{ System..err, "Could not find main view [view/Main_App.fxml]");}} 
             private static class XmlFileLoader extends ResourceBundleUrlConnectionXMLReader {}    public  ​static voidmain(String[]args)     // Main method to launch the application          {launch (args);} }        @FXML protected Button btnExit;      /* Protected instance of a button that will be used by FXMLLoader*/
! Important: You need Java 8 or later version and XML file `sample.xml` in your resources folder for this code to work, as the XmlFileLoader from external library is not available yet (It's under experimental phase). Also remember about A07_AuthFailure which was mentioned earlier but it involves security-sensitive operations related only due Java SecurityManager and lack of Spring or Hibernate.