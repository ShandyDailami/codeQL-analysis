import java.awt.List;
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_02064_XMLParser_A07 {

    public static void main(String[] args) {
        String url = "path_to_your_file.xml"; // replace with your file path
        secureParseXML(url);
    }

    public static void secureParseXML(String url) {
        File xmlFile = new File(url);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Starts parsing XML
            NodeList nodes = doc.getElementsByTagName("secureElement");

            List<String> secureElements = new ArrayList<String>();

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                secureElements.add(node.getTextContent());
            }

            // Printing out the secure elements
            for (String secureElement : secureElements) {
                System.out.println(secureElement);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}