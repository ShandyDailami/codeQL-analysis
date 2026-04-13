import java.io.*;  // Import FileInput and PrintWriter classes to read from a file and write to an output stream  
import javax.xml.parsers.*;//Importing the parser class java_52637_XMLParser_A03 XML data   
import org.w3c.dom.*;//To work with xml dom, import this package if not using SAX parsing or StAX APIs 
import org.xml.sax.SAXException; // Import SAX exception   and Pull handler classes to read the input (XML file)   
public class XMLParser {    
 public static void main(String[] args){     
 try{         
 parse("sampleFile");        
 }catch(IOException e1){            
 System.out.println("Something went wrong with reading from/writing files.");  
 e1.printStackTrace();              
} catch (SAXException e) {  //Catching SAX Exception for parsing the XML File           
System.out.println("\nParsing failed");         
e.printStackTrace();        }     }}       private static void parse(String fileName){      try{             
 DocumentBuilderFactory dbFactory =    DocumentBuilderFactory.newInstance();           //Creates a factory for reading data from an XML-based source  
DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();            //Provides methods to read the document  and creates DOM tree model of it       
            
dBuilder.setErrorHandler( new ErrorHandler(){                  public void fatalError (URI uri, String error) { System.out.println("Fatal parsing error: " +error);}} );        
Document doc = dBuilder.parse(new File(fileName));              //Parses the input data and constructs a DOM tree model of it           
doc.getElementsByTagName("*").item(0).getNodeName();             }catch (Exception e){                 System.out.println ("Caught an exception: " +e); }}  This will print out all tags in xml document starting from the root tag to end if there is no child node for a parent