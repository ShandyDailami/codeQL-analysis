import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_14578_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml"); // replace with your input file path
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            
            // Now you can handle the XML document here, e.g., print all element names
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
            printElementNames(doc.getDocumentElement());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void printElementNames(org.w3c.dom.Element element) {
        System.out.println("Element Name: " + element.getNodeName());
        if (element.hasChildNodes()) {
            for (int i = 0; i < element.getChildNodes().getLength(); i++) {
                printElementNames((org.w3c.dom.Element) element.getChildNodes().item(i));
            }
        }
    }
}