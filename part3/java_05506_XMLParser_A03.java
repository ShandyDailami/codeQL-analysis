import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_05506_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // create a factory for building a Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // create a builder for building a document
            DocumentBuilder builder = factory.newDocumentBuilder();

            // parse the XML document
            Document doc = builder.parse("src/main/resources/sample.xml");

            // print the document elements and attributes
            doc.getElementsByTagName("*").item(0).getNodeName();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}