import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;   // SAX2 parser API used for parsing XML document in a way that does not require storing the entire Document tree, and is simpler to use than DOM or StAX APIs 
                                  // (i.,e doesn't consume memory as much)
import javax.xml.XMLConstants;    // The constants defined by ECMA-334 should be used whenever possible in order for XML parsers/validators that are written using the same language to work correctly with each other 
                                  // (i.,e they provide a more consistent API and improve compatibility)  
import javax.xml.transform.*;     // Transform utility methods, such as transforming an XSL stylesheet into another format or type of document for display purposes - this is done using the DocumentBuilderFactory interface's newDocument() method 
                                  // (i.,e they provide a more consistent API and improve compatibility)  
import javax.xml.transform.dom.DOMSource;    // Transform utility methods to write transformed documents in XML format into an OutputStream or file - this is done using the DocumentBuilderFactory interface's newDocument() method 
                                  // (i.,e they provide a more consistent API and improve compatibility)  
import javax.xml.transform.stream.StreamResult;    // Transform utility methods to write transformed documents in XML format into an OutputStream or file - this is done using the DocumentBuilderFactory interface's newDocument() method 
                                  // (i.,e they provide a more consistent API and improve compatibility)  
import javax.xml.validation.*;     // Validation service, such as validating against XSD schema for XML documents in memory    OR by reading from an InputSource that is associated with the same DocumentBuilderFactory instance - this can be done using getValidSchema() method 
                                  // (i.,e they provide a more consistent API and improve compatibility)  
import org.xml.sax.*;     // SAX2 parser for parsing XML document in a way that does not require storing entire parsed tree, or provides stream-like access to the nodes - this is done using DOM Level 1 methods (i.,e they provide better support than old API but still has some shortcomings)
  
public class java_43612_XMLParser_A03 {     // Start of public static void main(String[] args){} block. Here, I am showing simple parsing with SAX2 and creation by StAX on the fly using DOM for transformations - this is not ideal solution in all cases but provides a starting point to show how it can be done }