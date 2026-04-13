import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import java.io.File;
import java.io.IOException;

public class java_23729_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Parse XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("input.xml"));

            // Step 2: Validate the document
            // This is a very basic validation. In a real-world application, you would likely use a
            // more complex schema or an XML Coder to validate the document against a specific schema.
            if (!document.hasChildren() || document.getDocumentElement().getTagName().equals("")) {
                System.out.println("XML document is not well-formed or is empty.");
                return;
            }

            // Step 3: Transform the XML into a different format
            // This is a very basic transformation. In a real-world application, you would likely use a
            // more complex transformation mechanism, such as using XSLT.
            Source xslt = new DOMSource(document.getDocumentElement());
            File resultFile = new File("result.xml");
            StreamResult output = new StreamResult(resultFile);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(xslt, output);

            System.out.println("XML transformation successful.");

        } catch (SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
}