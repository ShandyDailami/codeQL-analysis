import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_30669_XMLParser_A03 {
    public Document parse(String filePath) throws Exception {
        // Step 1: Create a DocumentBuilderFactory
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        // Step 2: Use the documentBuilderFactory to create a DocumentBuilder
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        // Step 3: Parse the XML document
        Document document = documentBuilder.parse(filePath);

        return document;
    }
}