import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_34478_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            String xmlFile = "sample.xml"; // path to your xml file
            File file = new File(xmlFile);
            InputStream inputStream = new FileInputStream(file);
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream);
            
            doc.getDocumentElement().normalize();
            
            System.out.println("Document read successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}