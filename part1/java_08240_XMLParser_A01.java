import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_08240_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "/path/to/your/file.xml"; // replace with your xml file path
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(new File(xmlFile));
            document.getDocumentElement().normalize();

            printElementNames(document, null);

            System.out.println("\nRoot element: " + document.getDocumentElement().getNodeName());

        } catch (Exception e) {
            System.out.println("Parsing the XML file failed");
            e.printStackTrace();
        }
    }

    public static void printElementNames(Document document, String padding) {
        NodeList list = document.getElementsByTagName("*");

        for (int i = 0; i < list.getLength(); i++) {
            if (padding == null) {
                System.out.println(list.item(i).getNodeName());
            } else {
                System.out.println(padding + list.item(i).getNodeName());
           
            }
            if (list.item(i).getChildNodes().getLength() > 0) {
                printElementNames(document, list.item(i).getNodeName());
            }
        }
    }
}