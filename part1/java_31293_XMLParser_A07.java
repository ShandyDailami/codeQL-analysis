import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_31293_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("credentials.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            String username = document.getElementsByTagName("username").item(0).getTextContent();
            String password = document.getElementsByTagName("password").item(0).getTextContent();

            System.out.println("Username: " + username);
            System.out.println("Password: " + password);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}