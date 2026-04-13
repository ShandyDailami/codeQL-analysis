import java.io.*;  // for FileInputStream, BufferedReader and PrintWriter  
import javax.xml.parsers.*;    // XML parser library (DomParser)     
import org.w3c.dom.*;     // Main classes interface of the DOM       
import org.xml.sax.*;       // SAX Parser Library 

public class java_51205_XMLParser_A07 {  
// main method to parse an xml file   
 public static void main(String[] args) throws ParserConfigurationException, IOException{     
     processXml("sampleInputFile");             
 }        
       
 private static DocumentBuilderFactory dbFactory;       // DOM parser factory         
 
 /** Method parses the XML document from a given input file */  
 public static void parseDocument(String inFile) throws ParserConfigurationException, IOException {     
     try{            
           System.out.println("Parsing complete!");             
         }catch (SAXException e){            // catching SAX exception for parsing the XML document 
               e.printStackTrace();                 
          } catch( Exception e ) {                 // Catch any other kind of exceptions that can occur   
                e.printStackTrace();                  
           };        
   }    
        public static void processXml (String inputFile) throws ParserConfigurationException, IOException{     
             dbFactory = DocumentBuilderFactory.newInstance();             
               try {                    // parsing the XML document with DOM parser         
                     DocumentBuilder dBuilder;                 
                      dBuilder=dbFactory.newDocumentBuilder();           
                       DocType docType= new DocType("sample", false);   /*Defining type of xml */ 
                        dBuilder.setDocType(docType );               // setting the doctype    
                     Document doc =dBuilder.parse(getFileAsInputStream(inputFile));                  
                      parseDocument(doc);              } catch (ParserConfigurationException e) {                 
                         System.out.println("Your Configuration is wrong, cannot parse this file");   /* Error in parsing configuration */ 
                          e.printStackTrace();                    
                       }     finally{               // closing the XML reader    };      }}      `};         }) ;} );}}))))) )); }); `})));