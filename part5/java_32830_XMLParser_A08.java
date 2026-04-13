import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_32830_XMLParser_A08 {

    public static void main(String[] args) {
        String fileName = "example.xml";

        File inputFile = new File(fileName);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;

        dBuilder.setEntityResolver(new MyEntityResolver());

        try {
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Document Loaded successfully.");
        } catch (SAXException me) {
            me.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}