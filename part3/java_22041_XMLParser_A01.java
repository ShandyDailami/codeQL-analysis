import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_22041_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            String filePath = "/path/to/your/file.xml"; // replace with your file path
            File file = new File(filePath);
            InputStream inputStream = new FileInputStream(file);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);

            // If needed, handle the document here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}