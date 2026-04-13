import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_16344_XMLParser_A07 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            File inputFile = new File("input.xml");
            Document document = builder.parse(inputFile);

            document.getDocumentElement().normalize();

            NodeList nodes = document.getElementsByTagName("AuthFailure");

            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("AuthFailure: " + nodes.item(i).getTextContent());
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}