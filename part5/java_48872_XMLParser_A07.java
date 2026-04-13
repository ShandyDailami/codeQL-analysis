import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_48872_XMLParser_A07 { 
    public static void main(String[] args) throws ParserConfigurationException, IOException{  
        // Create a new factory for handling XML files (this is required to read an xml file into DOM).          
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();           
     
     /*  Try catching possible exceptions here and print the error message */         
    try {             
         System.out.println("Try with default settings");              
        // Create a new document builder (using factory).            
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();                  
            // Parse an XML file into DOM object and print it's elements         
       File inputFile= new File("/path/to/xmlfile.xml");                 
        System.out.println("Try with external settings: "+inputFile);               
         dBuilder.setXIncludePatterns(new String[]{"/*"});               // Do not ignore comments, empty nodes etc ...   ## added to disable these by default            
          Document doc =dBuilder.parse( inputFile );                  /* Reading the XML file */  }}    catch (Exception e) {                 System.out.println("Error in loading xml " +e);}}     try{           // Write your logic here }catch(){System.out.printlns ("Caught");}