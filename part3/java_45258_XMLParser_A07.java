import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;   // Import the File and Filer classes
    
public class java_45258_XMLParser_A07 {   
      public static void main(String[] args) throws ParserConfigurationException, IOException  {       
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
           DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();            
            // parse using DOM parser         
               File inputFile  = new File("samplefile");   //Your XML file path goes here   
                Parser p =dBuilder .parse(inputFile);     # Parse your xml  into the Document object          
              dBuild.setEntityResolver(new EntityResolver() {        public Result createResult(String namespace, String name) throws NamespaceException{         return new InternalEntityReferenceImpl("");}});      // This allows us to use an external DTD in our XML          parse   # Parse the contents of the document into DOM tree.
              Document doc = dBuilder .getDOMParser().readDocument();      
              
           Element elem1=doc.getElementsByTagName("ElementToBeModified").item(0);  // Get specific element to be modified, replace "samplefile" and 'element' with your xml file name/path & tagname respectively   
            NodeList nodes = doc.getElementsByTagName ("*");       # this will parse all the tags in XML document        for (int i = 0;i <nodes . getLength();++ +      )  {   print( "node[%d]=< %s >", nodeNum, node );    }        
            Node newNode = doc.createElement("newElement");     # create a newly created element to be appended at specific location        Element existingElemmnt =  (Element) nodes . item ("existingChildName ");   // Get the child'node by name  replace "element", 'childname', and path with your data     
            doc.insertBefore(newNode, existingElemmnt);           # Insert new node before another specific element        Element elem = (Element) nodes . getNamedItem("tagName");     // Get a named item using its name  replace "element", 'childname' and path with your data   
            doc.appendChild(doc.getElementsByTagName ("newAppendedElem").item(0));        # append an element after another specific one      Node old = nodes . getNamedItem("tagToBeRemoved");   // Get a named item by its name  replace "childname" with your data      
            doc.removeChild (old);          # remove the node         printDoc();    }     catch { ...}};        PrintWriter pw=new Printwriter(System,out) ;p w .print("Error:... ");   }}      // handle exception  use 'catch' block to manage all exceptions in your code.