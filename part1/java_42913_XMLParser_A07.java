import javax.xml.parsers.*; // Parser classes from Java XML API 15+ required, so we use standard libraries only (no external frameworks) and no Hibernate or Spring here too - hence 'package' lines have been removed for brevity  
public class java_42913_XMLParser_A07 {    
    public static void main(String args[]){         
        try{          
            // Create a new instance of the XMLReader        
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();                  
             
            String xmlFile= "A07_AuthFailureSampleData/authfailuredata1.xml";// Provide your own XML file path here         
              
            // Parse the document using DOM parser          
            Document doc = dBuilder.parse(new File(xmlFile));            
             
            System.out.println("Root element : "+doc.getDocumentElement().getNodeName());      
  } catch (Exception e){        
        e.printStackTrace();      // Catch and print the exception to check for any error         
    }}    
}