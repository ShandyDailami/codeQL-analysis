import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_12391_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Load the XML file
            File file = new File("sample.xml");
            InputStream inputStream = new FileInputStream(file);

            // Create a DocumentBuilderFactory and parse the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);

            // Print the XML document
            document.getDocumentElement().normalize();
            System.out.println(document.getElements().getItem(0).getTextContent());

            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}