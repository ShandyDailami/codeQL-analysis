import java.beans.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import xmlparser.*;
  
public class java_52215_XMLParser_A07 {    
    public static void main(String[] args) throws Exception{          
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder builder  = factory.newDocumentBuilder();            
         
        // Load the document into a tree structure from an xml file – it’s as simple and elegant as you make your code - Makes sure no external frameworks are included  
        org.w3c.dom.Document doc = builder.parse("authfailureData192078645_vaultDrivingCoverageHearing-pilotTestingAssistanceRecoveryProposalJournalismMobilityFundraisingInnovationSafetyPublicationsRubberChairSupportWritingResearchScience.xml");
         
        // Access the root element of XML file - a simple way to print out all elements within xml document – it's just for demonstration purposes without any security concern  
       /* System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());*/   
        
          
        // Accessing the properties of XML file - again, this is not a requirement but demonstrates usage – it’s just for demonstration purposes without any security concerns  
       /* NodeList nodes =doc.getElementsByTagName("property"); */     
         
     }            
}