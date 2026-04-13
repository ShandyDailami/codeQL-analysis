import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_16314_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "example.xml"; // replace with your xml file

        try {
            File xmlFile1 = new File(xmlFile);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(xmlFile1);

            // If your XML file is very large, you may want to set a higher limit on memory
            doc.getDomConfig().setValidate(true);

            // Continue with your code here

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}