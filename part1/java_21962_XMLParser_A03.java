import java.io.FileInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class java_21962_XMLParser_A03 {

    public static void main(String[] args) {
        // Step 1: Parse XML file
        try {
            FileInputStream fis = new FileInputStream("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fis);

            // Step 2: Validate XML file
            Validator validator = doc.getDomConfig().getValidator();
            System.out.println(validator.getErrorLog().getTable());

            // Step 3: XPath query for security-sensitive operations
            NodeList nodes = doc.selectNodes("/root/user/name");
            for (int i = 0; i < nodes.getLength(); i++) {
                String name = nodes.item(i).getTextContent();
                System.out.println("User name: " + name);
            }

            // Step 4: Saving back the XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("secure_sample.xml");
            transformer.transform(source, result);

            System.out.println("XML file has been saved to secure_sample.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}