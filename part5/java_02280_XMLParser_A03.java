import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_02280_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml"); // replace with your xml file path
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("tag_name"); // replace "tag_name" with the name of the tag you want to extract

            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Node " + (i + 1) + ": " + nodeList.item(i).getTextContent());
            }

            // for example, if you wanted to extract the value of a specific attribute
            System.out.println("Attribute value: " + doc.getElementsByTagName("tag_name").item(0).getAttributes().getNamedItem("attribute_name").getNodeValue());

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}