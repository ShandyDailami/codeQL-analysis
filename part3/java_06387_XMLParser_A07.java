import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_06387_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "src/main/resources/authFailure.xml";
        File file = new File(xmlFile);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        System.out.println("Elements in the document:");

        NodeList nodes = doc.getElementsByTagName("*");

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String elementName = element.getTagName();
                System.out.println("Name: " + elementName);

                String value = element.getTextContent();
                System.out.println("Value: " + value);

                String regex = "A07_AuthFailure";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(value);

                if (matcher.find()) {
                    System.out.println("Security-sensitive operation related to A07_AuthFailure detected in the value: " + value);
                }
            }
        }
    }
}