import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_35631_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Load the XML document
            File inputFile = new File("input.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);

            // Remove the first node
            doc.getDocumentElement().normalize();
            doc.getDocumentElement().getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getFirstChild().getNextSibling().getFirstChild().getNextSibling().removeChild(doc.getDocumentElement().getFirstChild());

            // Output the modified document
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(doc);
            StreamResult streamResult = new StreamResult(new File("output.xml"));
            transformer.transform(domSource, streamResult);

            System.out.println("XML document successfully parsed and modified!");

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}