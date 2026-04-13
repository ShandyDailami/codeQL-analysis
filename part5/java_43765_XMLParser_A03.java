import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_43765_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{      
        // Step a: Using only standard libraries without external frameworks          
        
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
            
          try (DocumentBuilder builder=factory.newDocumentBuilder()) {  
                //Step b & c   
                  InputSource is= new InputSource(new StringReader("<note>\n" + 
                        "<to>Tove</to>\n" + "  <from>Jani</from>\n"+ "   <heading>Reminder</heading>\n"+ 
                         " <body>Don't forget me this weekend!</body><br /> \n" + 
                          "</note>"));   //Step e   
                  Document doc= builder.parse(is);    
                   
                   printElement("Elements by tag name: ",doc,"to");  //Step f      
                 } catch (SAXException ex) {                      
                     Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null,ex );        
                  }  
    }       
     static void printElement(String message , Document doc, String elementName ){      
           NodeList nlist =doc.getElementsByTagName(elementName);      //Step f         
            System.out.println("\n"+message + "Found :- "); 
             for (int temp = 0; temp < nlist.getLength(); temp++) {    
                Node nnode = nlist.item(temp);  
                  System.out.println("-" + nnode.getTextContent());          //Step f    }       
         }}