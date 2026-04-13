import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_32848_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File("sample.xml"));
            document.getDoctype();

            NodeList nodes = document.getElementsByTagName("*");

            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                System.out.println("Element " + (i + 1) + ":");
                System.out.println("Name: " + element.getTagName());
                System.out.println("Value: " + element.getFirstChild().getNodeValue());
                System.out.println();
            }

            builder.reset();
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}