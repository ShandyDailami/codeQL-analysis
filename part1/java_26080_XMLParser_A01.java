import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_26080_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // You can now manipulate the XML document here
            // For instance, print all element names
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            System.out.println("-------------------------------");
            System.out.println("Child elements :");
            for (int i = 0; i < doc.getChildNodes().getLength(); i++) {
                System.out.println(doc.getChildNodes().item(i).getNodeName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}