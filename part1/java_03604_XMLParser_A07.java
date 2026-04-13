import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_03604_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlData = "<data>Authentication failure</data>"; // sample XML data

        try {
            // Step 1: Parse the XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlData)));

            // Step 2: Handle Authentication Failure
            if (doc.getElementsByTagName("data").item(0).getTextContent().equals("Authentication failure")) {
                System.out.println("Authentication failure detected!");
                // Add your security-sensitive operation here
            } else {
                System.out.println("Authentication failure not detected!");
            }

            // Step 3: Transform the XML document to another format (optional)
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

        } catch (ParserConfigurationException | SAXException | TransformerException | IOException e) {
            e.printStackTrace();
        }
    }
}