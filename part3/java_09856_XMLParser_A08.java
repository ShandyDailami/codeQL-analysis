import java.io.File;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class java_09856_XMLParser_A08 {

    public static void main(String[] args) throws Exception {
        // Create DocumentBuilderFactory and DocumentBuilder instances
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML file
        Document doc = builder.parse(new File("input.xml"));

        // Print out XML structure
        printXmlStructure(doc);

        // Perform transformation
        transformXml(doc);
    }

    private static void printXmlStructure(Document doc) {
        System.out.println("\nXML Structure:");
        doc.getDomConfig().getValidateSchemaSource().getPublicId();
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        printElement(doc.getDocumentElement());
    }

    private static void printElement(Element element) {
        System.out.print(element.getNodeName());
        if (element.hasChildNodes()) {
            Iterator<Node> it = element.getChildNodes().iterator();
            while (it.hasNext()) {
                Node n = it.next();
                if (n.getNodeType() == Node.ELEMENT_NODE)
                    printElement((Element) n);
                else
                    System.out.print(" " + n.getNodeValue());
            }
        }
        System.out.println();
    }

    private static void transformXml(Document doc) {
        // Create TransformerFactory and Transformer instances
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // Set output properties for the Resulting SAX
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // Write out the document in an indenting and pretty-print XML
        transformer.transform(new DOMSource(doc), new StreamResult("output.xml"));

        System.out.println("\nTransformed XML:");
        printXmlStructure(doc);
    }
}