import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_13139_XMLParser_A07 {

    public static void main(String[] args) {

        // Using SAX Parser
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setValidating(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File("path_to_your_xml_file.xml"));

            // Extract information
            NodeList nodeList = document.getElementsByTagName("security");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Security operation: " + ((Element)node).getAttribute("operation"));
                System.out.println("Security level: " + ((Element)node).getAttribute("level"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}