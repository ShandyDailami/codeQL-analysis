import javax.xml.parsers.*;  // Provides classes for parsing XML documents, reading them in Java programs...  
import org.w3c.dom.*;       // Required elements of an HTML page are wrapped by the Document interface which extends this Interface ...   
import java.io.*;            // Needed to read file through InputStream and OutputStream  ....     
public class java_42871_XMLParser_A08 {    
 public static void main(String[] args) throws ParserConfigurationException, IOException  
{      
// Step1: Load an XML document using the DocumentBuilderFactory            
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        // step2        
factory.setFeature("http://xml.org/sax/features/namespaces", true);  /* to read xml with namespace */    
DocumentBuilder builder= factory.newDocumentBuilder();    //step3     
// Step4: Read the XML document and store it in Document object      
Document doc = builder.parse(new SourceResource("input.xml"));   // step5       
doc.getDocumentElement().normalize();                         /* normalizes an xml file */ 
NodeList nlist= doc.getElementsByTagName("employee");   
// Step6: Extract the data and store it in variables     
for (int temp = 0; temp <nlist.getLength(); temp++) {     // step7       
Element employee =(Element) nlist.item(temp);       /* getting a specific element */ 
String name  =employee.getElementsByTagName("name").item(0).getTextContent();   
int salary= Integer.parseInt((new DOMSource(   (Employee e, Element cdata_section ) throws Exception {}).fromEventNode ((Element) employee));        /* getting a specific element */  // step8     in integer value i will get the actual data from xml file . we need to cast it as per required.   
System.out.println("Employee's Name: " + name+" Salary :"  +salary);     
}        }          catch (Exception e){                 // step9 and finally clause is used when any exception occurs during the execution of try block then this will be executed .  
e.printStackTrace();                                                    /* to print error trace */ 
}}