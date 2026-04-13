import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_11943_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Step 1: Load the XML document
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Step 2: Extract the data from the XML document
            Element root = doc.getDocumentElement();
            Element user = (Element) root.getElements().get(0);
            String userName = user.getAttribute("name");
            String userEmail = user.getAttribute("email");
            System.out.println("User Name: " + userName);
            System.out.println("User Email: " + userEmail);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}