import com.sun.org.dom.parser.DOMParser;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

public class java_05167_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            InputStream inputStream = XMLParserExample.class.getClassLoader().getResourceAsStream("sample.xml");
            DOMParser parser = new DOMParser();
            parser.parse(inputStream);

            // Get the document
            Document document = parser.getDocument();

            // TODO: Perform security-sensitive operations related to A08_IntegrityFailure

            // Print the XML document
            document.getDocumentElement().normalize();
            System.out.println(document.getDocumentElement().getTagName());

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}