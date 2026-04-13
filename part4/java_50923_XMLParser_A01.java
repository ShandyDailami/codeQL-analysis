import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;   // Import BufferedReader for reading from file 
                   // (instead of a String)
public class java_50923_XMLParser_A01 {    
    public static void main(String[] args){     
        DocumentBuilderFactory dbFactory =      
            DocumentBuilderFactory.newInstance();        
          
          try{               
             DocumentBuilder dBuilder = 
                 dbFactory.newDocumentBuilder();   // Create a new document builder 
             
             Document doc =     dBuilder.parse(new File("inputFilePath"));       
              
                      ReadXMLFile readXmlFile=    new ReadXMLFile(doc);         
                     System.out.println("\nTag values: ");                  
                    try{                       
                       if (readXmlFile == null){                          
                         throw  new Exception ("Read XML file failed");       }                          // Call method to display tag value        return;    
                      readXmlFile.printData();         }}                  catch(Exception e1) {                 System.out.println("Caught the exception : " + 
               e1);          continue;}            finally{           if (doc != null){  doc.getDocumentElement().normalize();}}   // Prints whether document is valid       return; }   
        @SuppressWarnings({"rawtypes", "unchecked"})     public static class ReadXMLFile {         private NodeList nodeList ;              Document doc ;          Reader reader =  null ；           try{                     xmlReader(reader , "" )   // Call method to display tag value       }catch (Exception e){        System.out.println("Caught the exception : " +   +e ); return;}
                                                                                        public java_50923_XMLParser_A01(Document doc) {                  this .doc =      document;                nodeList =  null ;  try{             xmlReader(reader ,   "" ) }catch       (Exception e){System.out.println("Caught the exception: " +   +e); return;}       
                                                                                            public void printData()     throws Exception {                 Node nNode  = doc . getDocumentElement ()      null;            for  int i = 0 ;         if(nNode ==       null)          throw new NullPointerException ("Null node")                                                       }}}}`   // Prints whether document is valid