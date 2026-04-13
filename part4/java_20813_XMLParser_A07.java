import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_20813_XMLParser_A07 {
    public static void main(String[] args) {
        String filePath = "src/main/resources/example.xml"; // replace with your XML file path
        parseXMLFile(filePath);
    }

    private static void parseXMLFile(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));

            // Normalize the document
            document.getDocumentElement().normalize();

            // Retrieve and print the first 'element' node
            NodeList nodeList = document.getElementsByTagName("element");
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Element " + (i + 1) + ": " + nodeList.item(i).getTextContent());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}