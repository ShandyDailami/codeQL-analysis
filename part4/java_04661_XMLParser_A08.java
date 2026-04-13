import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_04661_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Start parsing data from the XML file
            parseData(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseData(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("node");
        for (int i = 0; i < nodeList.getLength(); i++) {
            String nodeValue = nodeList.item(i).getTextContent();
            // Do something with the node value
        }
    }
}