import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;  // Import the Reader and Writer classes to read from an InputStream or OutputStream class java_46255_XMLParser_A08 void parseXML() {   
         try{       
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
                 DocumentBuilder dBuilder  =dbFactory.newDocumentBuilder();      //Create a new document builder          
                 
                 DTDHandler handler=dBuilder .getDTDHandler ();   /* get the DTD support */   
                     handler.setValidate(false );  / Disable validation using DTD*/    
                      Document doc = dBuilder.parse("untrustworthy.xml"); // Parse the document into the tree model        return;       }         catch (Exception e){          System.out.println ("Caught Exception: " +e);    }}   while 1;}      if (!doc.hasChildNodes()) {System . out . println( "\n Empty Document" );}else{     for (Node node= doc.getFirstChild();node != null; ){ System . out .println(" Node Name : "+ node . getNodeName());}}}}}