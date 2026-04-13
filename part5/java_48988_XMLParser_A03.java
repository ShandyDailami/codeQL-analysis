import org.w3c.dom.*;
import javax.xml.parsers.*;
public class java_48988_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException 
    {     
        String myXmlfile = "mydata.txt";     // Assuming XML file is a text file in the same directory with name 'myData'         
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();     
        
       System.out.println("Parsing complete\n");     // Just to show that parsing is completed   
            
           try { 
            // parse the XML file             
               Document doc =dBuilder.parse(myXmlfile);  
                 
                doc.getDocumentElement().normalize();         
                         
                 NodeList nlist =  doc.getElementsByTagName("*");       
                      for (int temp = 0; temp <nlist .getLength();temp++) {   
                       //Printing all the names of XML tags  and attributes               System.out.println(doc.getElementsByTagName ("*" ).item(temp). getTextContent());           }            
                  dBuilder = null ;                      dbFactory=null;  
           
         /* This section is not required in this case, it's only here for demonstrating how to manipulate the data inside each node.  If you want further operations like reading from an XML file or writing into a database etc., then feel free */      }           catch (Exception e) {          System.out.println("Parsing failed: " +e);  
                                                                       return;                    }}