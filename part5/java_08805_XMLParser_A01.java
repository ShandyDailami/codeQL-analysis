import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.xml.parsers.DocumentBuilder;
import java.xml.parsers.DocumentBuilderFactory;
import java.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_08805_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("input.xml"));

            // Perform security-sensitive operations related to Broken Access Control
            // This is a simplistic example, actual implementation may be more complex
            String sensitiveData = document.getElements().getItem(0).getChildNodes().getItem(0).getTextContent();
            System.out.println("Sensitive data: " + sensitiveData);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}