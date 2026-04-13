import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.IOException;

public class java_02431_XMLParser_A01 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File inputFile = new File("input.xml");
        Document document = null;

        try {
            document = builder.parse(inputFile);
        } catch (Exception e) {
            System.out.println("Failed to parse the XML file!");
            e.printStackTrace();
       
            return;
        }

        document.getDocumentElement().normalize();

        NodeList list = document.getElementsByTagName("*");

        for (int i = 0; i < list.getLength(); i++) {
            Element element = (Element) list.item(i);

            String name = element.getTagName();
            String value = element.getFirstChild().getNodeValue();

            System.out.println("Tag: " + name);
            System.out.println("Value: " + value);
        }
    }
}