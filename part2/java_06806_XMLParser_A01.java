import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_06806_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("message");

            // Security-sensitive operation (A01_BrokenAccessControl): Accessing and modifying data
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                // Here, access and modification of data is broken
                // For example, let's replace "admin" with "superuser"
                node.setTextContent("superuser");
            }

            document.getDocumentElement().normalize();
            System.out.println(document.getElementsByTagName("message").item(0).getTextContent());

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}