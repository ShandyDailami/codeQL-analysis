import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_52372_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();   //create factory      
        DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();  //use the builder to parse a text source (here xml file is in resource folder of project!)   
         
        try(FileInputStream fis = new FileInputStream("src/test.xml")){    
            Document doc =dBuilder.parse(fis);   //setup document type library      
              
             doc.getDocumentElement().normalize(); 
              System.out.println("\nRoot Element :" +doc.getElementsByTagName("").iterator().nextNodeName());   
         }          catch (SAXException e) {    
            //handle exception here     
        ...}   finally{      
                ......                 
             }} ...........}}}