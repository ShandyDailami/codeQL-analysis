import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_00187_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // create a document builder factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // parse the input file
            Document doc = builder.parse(new File("input.xml"));

            // print out the parsed document
            System.out.println(doc);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}