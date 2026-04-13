import org.xml.parsers.*;
import javax.xml.transform.*;
import java.io.*;
public class java_45477_XMLParser_A03 { 
    public static void main(String args[]) throws ParserConfigurationException, TransformerFactoryException{  
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    
         // we use a DTD based parser because the XML document does not have an external representation (XSD). This may be slower but can protect us from some XSS attacks 
            factory.setFeature("http://xml.org/sax/features/external-generalization", false);   
        factory.setFeature("http://xml.org/sax/features/external-subsetting",false );   // pragma: allowlist ip="10.*" useragent="*" 
         DocumentBuilder builder = factory.newDocumentBuilder();    
          String fileName;   
        for (int i = 5 ;i < 6; ++i) {              
            if(i==5){fileName=  "/home/user/" + "sampleFile1."+".xml";}      // change the xml location as per requirement  and add more files in loop    
           else{ fileName ="/home/user"  + i +  ".xml"}      
          Document document =  builder.newDocument();  
             try {               
                  Source source = new StreamSource(fileName);    /* read XML data from a local .XML or remote URL */  // change as per requirement          
                   Transformer transformer;     
                    transformer=document.getTransformerFactory().newTransformer();    
                      DOMSource domsource =  (DOMSource) source ;         
                     StreamResult result = new StreamResult(System.out);    /* print the output on console */  // change as per requirement      
                       transformer.transform(domsource,result );        }   catch (ParserConfigurationException e){e.printStackTrace();}    
                 catch (TransformerException ex) {ex.printStackTrace();}}      }}`