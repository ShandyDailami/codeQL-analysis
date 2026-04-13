import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_08332_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml"); // replace with your xml file
        parseXmlFile(xmlFile);
    }

    public static void parseXmlFile(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);

            // Print out the XML document
            document.getDocumentElement().normalize();
            System.out.println("Root element: " + document.getDocumentElement().getNodeName());

            // Iterate over child nodes of the root element
            System.out.println("Child nodes of root element: ");
            for (int i = 0; i < document.getChildNodes().getLength(); i++) {
                System.out.println(" - " + document.getChildNodes().item(i).getNodeName());
           
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}