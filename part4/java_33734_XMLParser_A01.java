import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_33734_XMLParser_A01 {
    public static void main(String[] args) {
        String fileName = "sample.xml";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(fileName));

            System.out.println("Document loaded successfully.");

        } catch (IOException e) {
            System.out.println("Failed to load the file: " + fileName);
            e.printStackTrace();

        } catch (SAXException e) {
            System.out.println("Failed to parse the file: " + fileName);
            e.printStackTrace();
       
        }
    }
}