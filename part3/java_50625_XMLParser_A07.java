import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;    // to handle errors related SAX (Simple API for XML) events

public class java_50625_XMLParser_A07 { 
     public static void main(String[] args){  
          try{     
               DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
               DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();    // creates a new document builder          
            
               File inputFile =  new File("AuthFailureInputXMLDataSet1_A07");    
              if (!inputFile.exists()){  System.out.println("\nThe file " + inputFile +  "\nexists but can't be accessed, in order to proceed.");   return; }      // checks whether the XML data set exists and is accessible       
            
               Document doc = dBuilder.parse(inputFile);    // Parses a document based on the InputSource      
               
              parseDocumentNodeAuthFailure(doc);     # start of code with '#' removed for simplicity 
          }catch (ParserConfigurationException pce){      System.out.println("\nCaught \' Parser Configuration Exception\' : " +pce );   return;    // catches configuration related exceptions      
           catch (SAXException se){            # start of code with '#' removed for simplicity 
               System.out.print(" caught ' SAX exception ': ");          Se. printStackTrace();      return;}    
             }#end try-catch       
    };   // end main method        
       static void parseDocumentNodeAuthFailure( Document doc ){ # start of code with '#' removed for simplicity 
           NodeList nl =doc.getElementsByTagName("authFailures");          /* obtains the list of auth failures */     
            if (nl != null){        // checks whether we have an 'authentication failure'/n fail   # start simplification, change accordingly as per application requirement 
                for(int i = 0;i < nl.getLength();++i ){     /* iterates through each authFailure node */   
                  Node node =nl .item (i);       // gets the XML element named authentication failure   # start simplification, change accordingly as per application requirement 
                 if(node != null){      printAuthFailDetails((Element)节点 );}     }        return;              }}           /* end of parseDocumentNode Auth Failure */
             void PrintAuthFailureDetail ( Element element ){         # start simplification, change accordingly as per application requirement 
                    System.out .println (" Inside auth failure print detail : " +element.. getElementName());   }    return;}}}; /*end of class*/     `     ''''java