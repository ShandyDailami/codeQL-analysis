import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_13687_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/example.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Here you can handle the document like this:
            System.out.println("Root element: " + document.getDocumentElement().getNodeName());
            document.getDocumentElement().normalize();
            System.out.println("Child elements: ");
            for (int i = 0; i < document.getChildNodes().getLength(); i++) {
                System.out.println(document.getChildNodes().item(i).getNodeName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}