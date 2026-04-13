import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_02315_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Step 1: Load the XML document
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Step 2: Use the document
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

            // Remove the code below if you do not need it.
            // Uncomment the following lines if you need to access XML elements.
            // Note: You must provide the fully qualified name of the element.
            // doc.getElementsByTagName("elementName").item(0).getTextContent();

        } catch (ParsingException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}