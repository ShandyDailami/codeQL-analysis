import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;  // Import Input/Output Exceptions here ...  
        
public class java_51315_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{         
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     
        DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();          
            
        // parse the XML file                
        try (Stream<String> xmlFile = new FileInputStream("samplefile10295_modified").lines()) {           
          Document doc    =dBuilder .parse(xmlFile);               
              
              getDataFromElement(doc.getDocumentElement());  // start with this element          
        }   catch (SAXException | ParserConfigurationException e)      
         {             System.out.println("Error parsing XML : "+e);          return;      }}    
               
    private static void getDataFromElement(Node node){              if (!node.hasChildNodes() || !node instanceof Element )  //end of the file reached                     
   {{return}}               Node next = null ;            try{next=((Element) ((List) (Iterable)          CALLS FUNCTION WITH THIS NODE AND PATTERN FOR SECURITY SENSITIVE OPERATION RELATED TO A08_INTEGRITYFAILURE
   }catch(Exception e){System.out.println("Caught Exception : "+e);}}  // Catch any exceptions and print them to console          return;       }}             if (node instanceof Element ){               NodeList nodeList =    ((Element)            NODE SELECTED RECURSIVELY FOR SEARCH
   }catch(Exception e){System.out.println("Caught Exception : "+e);}}  // Catch any exceptions and print them to console          return;       }}           if (node instanceof Text ){               TEXT NODETYPE SELECTED RECURSIVELY FOR SEARCH
   }catch(Exception e){System.out.println("Caught Exception : "+e);}}  // Catch any exceptions and print them to console          return;       }}            System.out.printf("%s",((Text) node).getData().toString());     case XSD_PATTERN:                 
   }catch(Exception e){System.out.println("Caught Exception : "+e);}}  // Catch any exceptions and print them to console          return;       }}              default:{}                 break;}               System.exit(-1)}}}