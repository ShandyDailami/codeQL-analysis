import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_00901_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Load the XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            File inputFile = new File("resources/broken_access_control.xml");
            InputStream inputStream = new FileInputStream(inputFile);
            Document doc = builder.parse(inputStream);

            // Here you can add code to handle the document

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}