import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_23657_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the XML document
            Document doc = builder.parse(XMLParser.class.getResourceAsStream("/sample.xml"));

            // TODO: Add code to parse the XML document here
            // e.g. print out the document title
            System.out.println(doc.getDocumentElement().getNodeName());

        } catch (SAXException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}