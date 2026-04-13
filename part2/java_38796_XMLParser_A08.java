import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_38796_XMLParser_A08 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(new File("sample.xml")); // Replace with your XML file
        } catch (IOException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("student");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);

            String name = element.getElementsByTagName("name").item(0).getTextContent();
            String id = element.getElementsByTagName("id").item(0).getTextContent();
            String major = element.getElementsByTagName("major").item(0).getTextContent();

            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Major: " + major);
        }
    }
}