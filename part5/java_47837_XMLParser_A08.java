import javax.xml.parsers.*;
import org.w3c.dom.*;  // for Document, Element, NodeList etc...  
import java.io.*;     //for FileInputStream and BufferedReader classes..   
public class java_47837_XMLParser_A08 {     
private static final String FILE_PATH = "path/to/xmlfile";               
static XMLParser parser;         
  public void readXmlFile() throws ParserConfigurationException, IOException{  
        DocumentBuilderFactory dbFactory =  // creates a factory for the document builder.    
    DocumentBuilder docBuilder = parser.getDocumentBuilderFactory();      
      try(BufferedReader br = new BufferedReader (new FileReader ("path/to/xmlfile"))) {        
            int content;         
             while((content=br.read()) != -1){                  // read and print the characters     }                      catch block               
  public void writeToXmlFile() throws TransformerException, IOException{      Document doc = parser .newDocument();    try (PrintWriter pw =  new PrintWriter("path/to/xmlfile")) {                   document.write(pw);}   // close the writer and print in file } catch block