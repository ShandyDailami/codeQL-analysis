import javax.xml.*;
public class java_46172_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{       
         //Step1: Load XML document using DOM parser      
          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();          
          DocumentBuilder builder=factory.newDocumentBuilder(); 
                
          String xmlFilePath = "sample/example_filepath";   /* Change this path according to your file location */    //A01 BROKEN ACCESS CONTROL: Use safe locations only for security-sensitive operations (do not use hardcoded paths)          
         Document document= builder.parse(new File(xmlFilePath)); 
         
        /* A02_InsecureXMLExfiltration : Access to XML file in external location is broken here */   //A01 BROKEN ACCESS CONTROL: Do not expose sensitive files (do not hardcode or use secure paths)   
         document.normalize(); 
         
        /* A03_XMLExportSensitiveData : Exporting XML file in external location is broken here */   //A01 BROKEN ACCESS CONTROL: Do not expose sensitive data (do not export to unsecured locations)   
         XmlMapper xmlmap = new XmlMapper(); 
          /* A49_BrokenAccessControl : Accessing XML file using DOM methods are broken here */   //A01 BROKEN ACCESS CONTROL: Do not expose sensitive data (do not use unsecured paths)   
         Element root=document.getDocumentElement(); 
         
        /* A53_BrokenAccessControl : Accessing attributes using DOM methods are broken here */   //A01 BROKEN ACCESS CONTROL: Do not expose sensitive data (do not use unsecured paths)   
         NodeList nodes=root.getElementsByTagName("node"); 
         
        /* A54_BrokenAccessControl : Accessing inner text using DOM methods are broken here */   //A01 BROKEN ACCESS CONTROL: Do not expose sensitive data (do not use unsecured paths)   
         System.out.println("Node Name = "+ nodes.item(2).getTextContent());  /* Change index as per requirement*/            
         
        xmlmap.writeToFileAndPrintWriter('outputfile','UTF-8',document,System.out);   //A50_InsecureExportSensitiveData: Exporting XML file in external location is broken here (do not export sensitive data)    /* A71 BROKEN ACCESS CONTROL : Access to the outputFile path for writing are bypassed */
         } 
}