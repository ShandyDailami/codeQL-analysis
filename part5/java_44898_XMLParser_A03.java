import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_44898_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        XMLParser parser = new XMLParser();                         // Create the object of our custom xmlparser  
            
            File fileName=new File("sample.xml");  /*Your input .XML FILE NAME*/      
                DocumentBuilderFactory dbFactory = 
                    DocumentBuilderFactory.newInstance();    
                     
               int lineNumber= 1;                       /**Line Number Starts here */       
             
                 Parser parserObj =dbFactory.newParser();    // Create a new instance of the XML parsing engine  
            
                   reader =parserObj .getReader(fileName);  /*Creates an Xmlreader Object for reading xml file*/     
    	         int event=0;                          /**xml events starts here */           
                try {       
                  while (true)    //Infinite loop to read the XML document until all nodes are processed  
                 {                   if (! reader.hasAttributes()) ;  /* check for end of file*/                    break;}     else{      event =reader .getEventType();           switch(event){case XMLEvent.ELEMENT_NODE:    //starts a node element                case XMLEvent.ATTRIBUTE_NODE :  
                  caseXMLEvent,CALL_OVERRIDE ;  break; default;} reader_.next(); }     event=reader .getEventType (); switch(event){case XMLChars: /*print the character data*/            System..println ("Character Data:"+read.getText());break };  
                   //processes next Event type ie node,attrib ,end etc      break;  default ; }}}        case XMLEvent .COMMENT :    //handles comments...       println("Comment: " + reader_.getData ());         event =reader.next(); }}                  };
                try {   /*if there are any issues at parsing the xml file, it will be caught in this block of code*/  catch(Exception e){System .outprintln ("Error :"+e); }     finally{ reader_.close();}}; //closes XML Reader.         System..println("Done");   
                /*This is a simple example and doesn't include all the features you might need in real-world applications*/   };              catch (Exception e) {  try {}catch(Throwable t){}; } });      }} ;; //end of main Method.     void setUp() throws Exception{}}