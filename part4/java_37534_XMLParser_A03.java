import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_37534_XMLParser_A03 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(new File("persons.xml"));
            document.getDocumentElement().normalize();

            NodeList personNodes = document.getElementsByTagName("person");

            for (int i = 0; i < personNodes.getLength(); i++) {
                Element personElement = (Element) personNodes.item(i);

                String name = personElement.getElementsByTagName("name").item(0).getTextContent();
                String age = personElement.getElementsByTagName("age").item(0).getTextContent();

                System.out.println("Name: " + name + ", Age: " + age);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}