import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
// import necessary libraries for DOMParser and XPath here if needed... (For instance, use XMLHttpRequest or fetch API to get URL)

public class java_51980_XMLParser_A07 { 
    public static void main(String[] args){  
        try{    
            // replace 'restrictedFileLocation.xml' with your real file location     
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();      
            
            /*DOMParser is a part of DOM, which represents the document in an XML or HTML format as objects and nodes*/   
              DomHandler domh=factory.newDocumentHandler(null);        //Creates new instance    
               XPath xp =XPathFactory.newInstance().newXPath();  /*This is for executing a query on xml using the expression provided */  
             URL url =  (URL) getClass() .getResource("restrictedFileLocation.xml");      System.out.println(url);    //Getting file from resource    
            domh=domh;       Document doc =((DocumentHandler) xp).parse(new InputSource( new java.io.StringReader ( url)));   /*Parse the xml document with factory and input source */ 
             NodeList nl =  ((Element)(doc)).getElementsByTagName("restrictedTag1");    //Selecting a element by tag name 'Restricted Tag'      for loop to get all nodes using node list     if (nl.getLength() > 0) {        System .out.println ("Found " + nl.getLength ()+" restricted elements ");         }
               else  println("No RestrictTag1 found");   //if not, then it will execute the following code    }} catch(Exception e){System out; PrintStackTrace();}}          /*handling exception */      System .out ( "Caught Exception: " +e);     try { Thread.sleep(2000) ;}catch (InterruptedException ie ){ 
              //ignoring the interruption, it is normal in this case to do so    }}       }   /*End of Main method */ });}}`});