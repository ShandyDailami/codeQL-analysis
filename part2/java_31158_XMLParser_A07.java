import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import java.io.File;

public class java_31158_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            
            // Here, you can start working with the parsed XML document
            // For example, print out the names of all elements
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            System.out.println("Child elements: ");
            for(int i=0; i<doc.getChildNodes().getLength(); i++) {
                System.out.println(doc.getChildNodes().item(i).getNodeName());
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}