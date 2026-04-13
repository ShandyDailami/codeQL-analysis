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

public class java_39956_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a factory for reading the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 2: Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Step 3: Print the content of the XML file
            printDocument(doc);

            // Step 4: Use SAX parser to parse the XML file
            SAXParserHandler handler = new SAXParserHandler();
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser(handler);
            saxParser.parse(new File("sample.xml"));

            // Step 5: Use DOM parser to parse the XML file
            DocumentBuilder dbBuilder = factory.newDocumentBuilder();
            Document doc2 = dbBuilder.parse(new File("sample.xml"));
            printDocument(doc2);

            // Step 6: Use Transformer to format the XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc2);
            StreamResult result = new StreamResult(new File("formatted.xml"));
            transformer.transform(source, result);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        System.out.println(doc.getDocumentElement().getTagName());
    }
}