import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_42147_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            String xmlFile = "/path/to/your/xml/file.xml";  // replace with your xml file path
            File xmlFilePath = new File(xmlFile);

            if (!xmlFilePath.exists()) {
                System.out.println("XML file not found!");
                return;
            }

            InputStream inputStream = new FileInputStream(xmlFilePath);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream);

            doc.getDocumentElement().normalize();

            String tagName = "elementName";  // replace with your target tag
            parseElements(doc.getElementsByTagName(tagName));

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseElements(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                System.out.println("Element: " + element.getTagName());
                // Do something with the parsed element here
            }
        }
    }
}