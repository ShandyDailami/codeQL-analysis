import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_25286_XMLParser_A08 {
    public static void main(String[] args) {
        String filePath = "test.xml"; // Assuming the file is in the same directory as the class
        parseFile(filePath);
    }

    public static void parseFile(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false); // Disable validation to make the code simpler
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;
        try {
            document = builder.parse(new File(filePath));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return;
        }

        document.getDocumentElement().normalize();

        Element root = document.getDocumentElement();
        if (root.getNodeName().equals("test")) {
            String value = root.getAttribute("value");
            System.out.println("Found 'test' with value: " + value);
        } else {
            System.out.println("Root node is not 'test'");
        }
    }
}