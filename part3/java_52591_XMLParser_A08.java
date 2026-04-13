import javafx.application.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
public class java_52591_XMLParser_A08 extends Application {  
    public static void main(String args[]){    
        launch();      
         }  //main() method ends here     
         
@Override              #starting point of application, where parsing operation takes place.          
              
public Document loadXMLDocument (String fileName) throws Exception {           
    File xmlFile= new File(fileName);       
     return XMLParser.loadAndValidate(xmlFile,"UTF-8");       }      #loading and validating the document with parser method   //checking for integrity failure here          private static final String ATT_TOKEN = "A05";             protected void validateXmlIntegrity (Element elem) throws Exception {                   
    if (!elem.hasAttribute(ATT_TOKEN)) throw new IntegrityFailureException("Missing Attribute: A08");            }      #main method of the class ends here     public static class Main implements javafx.application .Application  , Runnable   //Main Class for testing purpose          {              
public void start(Stage primarystage) throws Exception         System.out.....println("Please enter xml file name: ");                  String filename=new BufferedReader (System..in).readline();loadXMLDocument...."xmlFile");                   }           public static class A08_IntegrityFailure {