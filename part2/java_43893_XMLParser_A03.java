import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_43893_XMLParser_A03 { 
    public static void main(String[] args) throws ParserConfigurationException, IOException{  
        // Step1 - Parse XML file with external library (SAX parsing in this case). Use SAX parser to parse an entire document:    
         System.out.println("Step2 : Using XmlReader");   
          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
        // DB factory - creates DOM-based builder for parser configuration and 1st step initialization with the input XML file to be parsed by a SAX Builder:    
         ParserContext pc = dbFactory.newDocumentParser(args[0]);   
          System.out.println("Step3 : Starting parsing at Node " +   pc.getCurrentNode()); // Print current node in DOM document for verification purpose     
        /* Step 4 - process XML documents step by steps: */     DocumentBuilder db = null;       if(pc !=null) {          System.out.println("Step5 : Inside the parser");         } else{System.err .Println ("Exception found in Parsing.");}   
        // SAX parsing  - set-up an event handler:     EventHandler listener = new CustomHandler();      pc.setContentHandler(listener);          System.out.println("Step6 : Setting the Content Handler");   } else {System .err.. Println ("Exception setting contenthandler in parser.");}
    // Call parse method and print error info if exception occurs:     try{pc.parse (args[0]);  }catch(SAXException se){se.printStackTrace(); System out!Printf(" caught SAX Exception"); return;   }}else {System .err.. Println ("Exception setting contenthandler in parser.");}
    // Here is the implementation of EventHandler for parsing:     class CustomHandler implements 	EventHandler{public void startElement(String uri, String localName ,	String qName, Attributes attributes)throws SAXException   { System.out .Println ("Start element : " +localName);}}   
}