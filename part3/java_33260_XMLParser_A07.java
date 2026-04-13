import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_33260_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("authFailure.xml");  // replace with your xml file
        parseXML(xmlFile);
    }

    private static void parseXML(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList authFailures = document.getElementsByTagName("AuthFailure");
            handleAuthFailures(authFailures);

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void handleAuthFailures(NodeList authFailures) {
        for (int i = 0; i < authFailures.getLength(); i++) {
            // security-sensitive operation here, for example:
            System.out.println("AuthFailure: " + authFailures.item(i).getTextContent());
        }
    }
}