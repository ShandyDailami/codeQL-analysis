import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_48105_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        File file = new File("sample_data"); //replace with your xml path here     
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();                
            DocumentBuilder builder = factory.newDocumentBuilder();   
                        
            try {          
                Document doc = builder.parse(file);              
                            
                NodeList nodes =  doc.getElementsByTagName("AuthFailure");             
                         
                for (int i=0;i<nodes.getLength();i++)  //Iterate through each Auth Failure element and print out its node name            
                    System.out.println( ((Element)nodes.item(i)).getTextContent() );    
            } catch (SAXException e){  
                e.printStackTrace();              
              }         
    }       
}  //end of main method        `