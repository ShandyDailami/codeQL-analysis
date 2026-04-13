import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_03082_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "path_to_your_xml_file.xml";
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(xmlFile);

            // Here you can process the XML document. For example, you can print all the tags and their values.
            doc.getElementsByTagName("*").item(0).getChildNodes().item(0).getNodeValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}