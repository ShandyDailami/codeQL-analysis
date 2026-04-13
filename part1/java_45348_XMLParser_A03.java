import java.io.*;  
import javax.xml.parsers.*;  
import org.w3c.dom.*;       // Import these classes to manipulate xml document in Java     
    
public class java_45348_XMLParser_A03 {        
// Creating a new instance of DocumentBuilderFactory 
DocumentBuilderFactory factory = null;   
DocumentBuilder builder=null;       
         
 public void parse(){          
 try{           
   // Create an instance for Factory            
       factory =  DocumentBuilderFactory.newInstance();     
    
       /* create the parser from DOM Builder */             
         System.out.println("Using Dom"); 
               builder =factory.newDocumentBuilder();   
        }catch(Exception e){                     
           // Catch Exception for handling any problem and do something...  
            System.err.print(e);                 
      }}    
      
public void parseFile(){        
 try{             
  File inputFile = new File("sample.xml");    // your file name/path here       
         
 /* create the parser from DOM Builder */              
           builder=factory.newDocumentBuilder();  
            System.out.println(inputFile);     
             }catch (Exception e){                   
                 System.err.print(e+"");                  // Catch Exception for handling any problem and do something... 
              }}    
public static void main(String args[]) {          
 new ParseXML().parse();                      /* Create Object of class */     
 }    public Element getElementByName(Document doc, String name){       return   (Element )doc.getElementsByTagName("tagname") .item(0);  // replace tagname with your xml element}};             
}