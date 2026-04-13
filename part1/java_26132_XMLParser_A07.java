import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_26132_XMLParser_A07 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("src/main/resources/example.xml"));

            doc.getDocumentElement().normalize();

            NodeList nlist = doc.getElementsByTagName("note");

            for (int temp = 0; temp < nlist.getLength(); temp++) {
                Node node = nlist.item(temp);

                Element element = (Element) node;

                String id = element.getAttribute("id");
                String content = element.getTextContent();

                System.out.println("Note id: " + id + ", Content: " + content);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}