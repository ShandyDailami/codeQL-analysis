import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.net.URL;
import java.net.MalformedURLException;

public class java_08957_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com/sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(url.openStream());

            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("note");

            for (int i = 0; i < list.getLength(); i++) {
                Element e = (Element) list.item(i);
                System.out.println("Note " + (i + 1));
                System.out.println("Title: " + e.getAttribute("title"));
                System.out.println("Description: " + e.getAttribute("description"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}