import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class java_37322_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("people.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("person");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String age = element.getElementsByTagName("age").item(0).getTextContent();
                System.out.println("Name: " + name + ", Age: " + age);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}