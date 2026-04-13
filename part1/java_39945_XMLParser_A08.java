import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_39945_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml"; // Replace with your own XML file
        parseXmlFile(xmlFile);
    }

    public static void parseXmlFile(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(new File(xmlFile));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
            return;
        }

        getStudents(doc);
    }

    public static void getStudents(Document doc) {
        Element root = doc.getDocumentElement();
        System.out.println("Root element: " + root.getNodeName());

        NodeList studentNodes = root.getElementsByTagName("student");

        for (int i = 0; i < studentNodes.getLength(); i++) {
            Element studentElement = (Element) studentNodes.item(i);

            String name = studentElement.getElementsByTagName("name").item(0).getTextContent();
            String age = studentElement.getElementsByTagName("age").item(0).getTextContent();

            System.out.println("Student: " + name + " (" + age + " years old)");
        }
    }
}