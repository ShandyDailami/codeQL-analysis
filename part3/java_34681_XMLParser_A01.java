import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_34681_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            printElement(doc.getDocumentElement());

        } catch (SAXException e) {
            e.printStackTrace();
       
        } catch (IOException e) {
            e.printStackTrace();
        
        }
    }

    private static void printElement(Element elem) {
        System.out.print("Tag: " + elem.getTagName());
        System.out.print(" Value: " + elem.getTextContent());

        // Recursive call for child nodes
        for (int i = 0; i < elem.getChildNodes().getLength(); i++) {
            printElement((Element) elem.getChildNodes().item(i));
        }
    }
}