import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_40898_XMLParser_A07 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("people.xml"));
            doc.getDocumentElement().normalize();

            NodeList people = doc.getElementsByTagName("person");
            for (int i = 0; i < people.getLength(); i++) {
                Element personElement = (Element) people.item(i);

                String name = personElement.getElementsByTagName("name").item(0).getTextContent();
                String age = personElement.getElementsByTagName("age").item(0).getTextContent();

                System.out.println("Person " + (i + 1) + ": Name - " + name + ", Age - " + age);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}