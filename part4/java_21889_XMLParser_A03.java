import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_21889_XMLParser_A03 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("sample.xml")); //replace with your xml file
            System.out.println("XML file parsed successfully");
        } catch (SAXException e) {
            e.printStackTrace();
       .
.
.
.
        //more code here
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}