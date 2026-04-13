import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class java_33464_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Load the xml file
            File xmlFile = new File("path_to_your_xml_file.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Extract data
            NodeList nodeList = document.getElementsByTagName("item");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    Element element = (Element) node;
                    String authFailure = element.getAttribute("authFailure");
                    if ("true".equals(authFailure)) {
                        System.out.println("AuthFailure detected in item: " + i);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}