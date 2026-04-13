import org.w3c.dom.*;
import javax.xml.parsers.*;
public class java_52912_XMLParser_A03 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     // Create a factory for reading the XML file      
	    DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();     
         String xmlFilePath="src/test.xml";  /* Provide your own path */   
         
        try {  
            Document doc =dBuilder.parse( new File(xmlFilePath) );     //Parse the XML file and store in document object      
            
           GetDataFromXML(doc);      /// Read data from xml using recursive function 
                       
         } catch (Exception e1) {  
            e1.printStackTrace();    /* Handle exceptions */       
         
     }} // end main method and close braces for exception handling            
      
 public static void GetDataFromXML(Document doc){      /// Parse data from xml  with recursive function        
           NodeList nl =doc.getElementsByTagName("*");    /* get all the children nodes */           
              // Calling a Recursion Function on each child node  
                for (int temp = 0;temp <nl.getLength();temp++)     {       GetDataFromXML((Element) nl.item(temp));          }        
                  else{        /* if the current element is not any of xml's tag then parse data*/             
                        System.out.println("Tag Name: "+doc.getElementsByTagName("*").item(0).getTextContent());  // Printing out all text inside a node      }}}}             };}}// end recursion function and close braces for exception handling                     }}                );}                          });