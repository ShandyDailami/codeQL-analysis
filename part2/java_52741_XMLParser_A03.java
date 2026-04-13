import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_52741_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{       
           // Create a new instance of DocumentBuilderFactory      
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();         
            
                try (// Use the XMLReader from DOM to read and parse an XML document     
                     XmlReader reader = factory.newDocumentBuilder().newTreeReader(       
                         // open a connection on your hard drive at path           
                             new File("C:\\Users\\YourPathToXMLFile")         , "UTF-8")){            
                    for (int event; reader.getEventType() != Node.ELEMENT_NODE;) {             
                        switch(event = reader.getEventType())   // read the XML document node by node                    
                            case CharacterData:  /* ignore character data */                break;         
                                                  default : if (reader instanceof ElementReader)    ((ElementReader)       reader).startElement("", "", "");        }             });            };     catch(Exception e){ System.out.println ("Caught exception " +e);};               }}  // end of main() method                 Sorry for the inconvenience this has caused, but I hope you understand my statement!