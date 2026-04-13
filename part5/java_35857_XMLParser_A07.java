import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_35857_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document doc = builder.parse(new File("authfailure.xml"));

            // Get all AuthFailure elements
            NodeList list = doc.getElementsByTagName("AuthFailure");

            // Extract and print AuthFailure information
            for (int i = 0; i < list.getLength(); i++) {
                Element element = (Element) list.item(i);
                String authFailure = element.getAttribute("AuthFailure");
                System.out.println("AuthFailure: " + authFailure);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}