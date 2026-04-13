import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_30638_XMLParser_A08 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("src/main/resources/data.xml"));
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("item");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Document itemDoc = nodeList.get(i).getDocumentElement();

                String name = itemDoc.getElementsByTagName("name").item(0).getTextContent();
                String quantity = itemDoc.getElementsByTagName("quantity").item(0).getTextContent();

                System.out.println("Name: " + name + ", Quantity: " + quantity);
            }

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}