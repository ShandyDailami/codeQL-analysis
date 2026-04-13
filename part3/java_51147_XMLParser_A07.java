import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
  
public class java_51147_XMLParser_A07 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        // Parse the XML file using DOM parser and check for 'authfailure' in each parsed document:
         parseXML("src/test.xml", "A07_AuthFailure");  
    }    
      
      public static void parseXML(String filename, String authFail) throws ParserConfigurationException, SAXException { 
        FileInputStream fis = new FileInputStream(filename);  // create a file input stream to read the XML data from disk:          
         DocumentBuilderFactory dbFactory = 
             DocumentBuilderFactory.newInstance();  
          DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();   
            DOMParser parser=dBuilder.newDOMParser();    
              int lineNumber = 0;  // variable to keep track of the current XML element:     
         try{      
             System.out.println("\nFinding 'A07_AuthFailure' in all documents......\n");  
            parser.setEntityResolver(new EntityResolver() {        public InputSource resolveEntity(String arg0) throws SAXException { return new InputSource(  //disable entity resolver      } });   
             try{    
                 for ( ;; )         {              Document doc =  parser.parse("", null);       lineNumber=1;                    Element root =   doc .getDocumentElement();          checkNodeA07AuthFailure((Node)root,authFail );        //exit the loop if all documents parsed successfully:  }     
             catch(Exception e){     System.out.println("\nError at Line " + lineNumber  +": \""+e.getMessage()+"\"");}              }}catch (SAXException ex) {ex.printStackTrace();}}          //end try-catch block    };   } 
      void checkNodeA07AuthFailure( Node node, String authFail ){     if ("authfailure".equalsIgnoreCase((node.getNodeName())))        System.out.println("Security violation: ' A " + (new java.util.Date())+" - Document element contains the keyword Auth Fail :A07_AuthFailure ");}}