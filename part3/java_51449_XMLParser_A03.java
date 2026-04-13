import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_51449_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{ 
        //1- Load the xml file from a resource in your jar (Assuming it is inside resources folder). Use FileInputStream if you are loading directly form user input or directory.    
       InputSource source = new InputSource(new StringReader("<root><element>value_in_samplefilexmlparser/root<>"));  // Read file from disk as an in-memory stream for simplicity   
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
         factory.setValidating(true);     # Use this if you want to validate XML document with XSD schema, but it's not possible now via standard java API only  // Also note that javax parser does have validation feature   
        DocumentBuilder builder=factory.newDocumentBuilder();     
       org.w3c.dom.Document doc =builder .parse(source);     #org domain document is a tree structure of nodes and elements, it can be used to access data in the xml file directly  // Here we are using standard java API only   Document has read-only property called lastModified which will give you timestamp when this specific XML was parsed.
        doc .getDocumentElement().normalize();     # Normalizes an document by moving all contained elements into their own tree and removing extra whitespace (if any)  // Removing the comments, to show how it is done in xml parsing    Document has a getLineNumber() method that returns line number of last modification.
        NodeList nodeList = doc .getElementsByTagName("*");   # selects all elements under current element and return as list nodes  //Selecting the text from XML file (value_in)     for(int i=0;i<nodeList.getLength();+++){    Element eElement  = nodeList