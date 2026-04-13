import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_16390_XMLParser_A03 {
    public static void main(String[] args) {
        // Step 1: Create a DocumentBuilderFactory and a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 2: Use the DocumentBuilder to parse the XML document
        Document document = null;
        try {
            document = builder.parse(new File("sample.xml")); // Replace with your XML file
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 3: Query the document
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            System.out.println("Node " + i + ": " + element.getTagName());

            // Add more code here to handle and secure the injection attacks related to A03_Injection
        }
    }
}