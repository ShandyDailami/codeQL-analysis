import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_47348_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{     
        File xmlFile = new File("path_to/yourXmlfile");        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();    
         
        try(FileReader reader= new FileReader(xmlFile)) {  
            //parse the xml file          
            Document doc =dBuilder.parse(reader);   
             
             getDetails(doc, "");      
         }  catch (SAXException e) {    
                System.out.println("Parsing failed: " +e );      return;  
        }         
    }                  
              
           private static void getDetails(Document doc, String indent){             
            NodeList nlist =doc.getElementsByTagName("User");  // Get all User details    
             for (int i = 0;i <nlist .getLength(); ++) {     
                try{         
                    Element element=   (Element) nlist.item(i);          
                     String username =element.getAttribute("username" );       str += "Username:  ";     // Add your secure operation here for the sensitive information        }catch{}    continue;         }}             catch {continue;}              System.out.println("\nUser-" + i+1);      getDetails(doc, indent  + "\t");  
                 if (i< nlist .getLength()- 1)          str += "--------";     // Add your secure operation here for the sensitive information        }catch{}       }}    System.out.println("\n" +indent+str);}}      catch(Exception e){System.out.print("Error : xml file reading failed.");}