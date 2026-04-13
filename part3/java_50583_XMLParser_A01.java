import java.io.*;   // for FileReader use only (not needed if working with Java built-in classes)
import javax.xml.parsers.*;    // Provides API to parse XML files into Document Object Model(DOM), XPath Query Language and SAX parser APIs, which can be used in non threaded environment  
public class java_50583_XMLParser_A01 { 
     public static void main (String[] args){     
          try{            
               String xmlFile = "/home/user/Documents/sampleFile1245876.xml"; //Replace with your file path and name             
                FileReader fr= new FileReader(new File(xmlFile));      
                 SAXParserFactory spf =SAXParserFactory.newInstance();   
                  SAXParser saxParser  =spf.newSAXParser(true, false);     // Creates a DefaultHandler by default which we will use later to get our data  
                   MyContentHandler mycontenthandler= new  Main().new ContentHandlerImpl() ;     
                   saxParser .parse(fr ,mycontenthandler );    /* Parsing the XML file */        
          }catch (Exception e ) {        // Catch and print exception if there is any.  
               System.out.println("Error parsing xml: "+e);  };          
     }}