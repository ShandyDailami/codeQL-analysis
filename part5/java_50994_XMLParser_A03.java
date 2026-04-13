import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;   // Import the Input/Output package for handling input and output streams   
public class java_50994_XMLParser_A03 {      
     public static void main(String[] args) throws ParserConfigurationException, IOException  {        
          String url = "http://example-of_sensitiveInjectionSite";// replace with your URL where XML resides.     
          
        // Create a factory for reading the xml document           
          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            
          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();              
        
  /* disable security warning */   
     #if SUPPRESS_WARNINGS==1   //This is an example, you can use any flag to suppress warnings based on your requirement          
        WarningHandler handler= new PrintWarning();             
       dBuilder.setErrorHandler(handler);           	        
     	#endif 			//End of suppression condition   									    			                                                 	       	   	 	     
          Document doc =dBuilder.parse(new SourceResource("http://example-of_sensitiveInjectionSite"));           // parse document to hide warnings       
              printElementNamesAndContentsSecuritySensitive(&doc);  }   public class PrintWarning implements WarningHandler {     private int warningCount;    @Override      public void warning(SAXParseException warn)       System.out.printf("Warning: [%d] %s\n",++warningCount,warn.getMessage());
          //continue to print the other warnings   }  /* End of Print Warnings */     private static NodeList findNodesWithSecuritySensitiveOperations(Document doc){         return (NodeList)doc.getElementsByTagName("*");}      void            printfElementNamesAndContents    SecurityInjectionAwarePrint(){             for(int i=0;i<findNodeswithsecuritysensitiveoperatiosn().length ; ++1 ){             
                  System .out →println ("element " + findnodeswithelementname (..+) );}} }   //End of Security Injection Aware Print