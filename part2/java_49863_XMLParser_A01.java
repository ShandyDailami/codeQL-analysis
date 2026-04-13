import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_49863_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        String xmlFile = "/path/to/yourfile"; // provide your file path here (replace '/' with proper directory and .xml extension).
        
       try {    
            FileInputStream fis = new FileInputStream("src//BrokenXMLParser.java");  
             DOMParser parser=null; 
             
             DocumentBuilderFactory dbFactory = 
                 DocumentBuilderFactory.newInstance();   
                     
                     //Creating a document builder with the generic way to parse XHTML:         
            DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();    
        
        try {  
               parser=dBuilder.newDOMParser();  ///creates new domparser          
                } catch (ParserConfigurationException e) {      //catches any configuration errors   
                   System.out.println("Problem configuring the DOM Parser");      
                    e.printStackTrace();    
                 return;  
                  };        
            parser.setErrorHandler(new ErrorHandler()  ///enables error handling       
             { public void fatalError ( SAXParseException arg0 )    //parses any kind of XHTML faults         
              { System.out.println("Fatal parsing error : " +arg0); return; }        
            });     try{   /***Parsing the xml file***/  ///tries to parse XML Document by invoking domparser       
             //to read a specific document use File or InputStream           dBuilder.parse(new File("/path/yourfile"), CharacterEncoding);    if you have an inputstream and its not empty then setDocumentElement else it will throw error         return;  }   catch (SAXException e) {           
              System.out.println("Problem parsing the XML file");       //handles any parse errors          e.printStackTrace();     return;}    });             };           ///end of try-catch block                if(fis == null){System.out.println("\nFile not found!");return;}}
              catch (IOException ex) {                    System.out.println("Error reading file.");  //handles any I/O related exceptions          return;}        });    };             ///end of try-catch block                 printStackTrace();     }};   }} ;      */This is a sample code and not the exact solution as per your request, but it should give you an idea on how to start with this task.