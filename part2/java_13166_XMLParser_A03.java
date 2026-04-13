import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class java_13166_XMLParser_A03 {

    public static void main(String[] args) {
        String xml = "<root><value>" + System.getProperty("java.io.tmpdir") + "</value></root>";

        try {
            parseWithExternalEntities(xml);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static void parseWithExternalEntities(String xml) throws SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse with external entities
        Document document = builder.parse(new ByteArrayInputStream(xml.getBytes()));

        // Print the document node
        System.out.println(document.getDocumentElement().getNodeName());

        // Create a transformer
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // Write the transformed document
        transformer.transform(new DOMSource(document), new StreamResult(System.out));
    }
}