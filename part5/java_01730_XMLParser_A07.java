import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_01730_XMLParser_A07 {
    public static void main(String[] args) {
        String fileName = "authfailure.xml"; // Provide your XML file name here

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(fileName));

            NodeList nodeList = document.getElementsByTagName("SecurityEntity");

            for (int i = 0; i < nodeList.getLength(); i++) {
                String securityEntity = nodeList.item(i).getTextContent();
                System.out.println("SecurityEntity " + (i + 1) + ": " + securityEntity);
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}