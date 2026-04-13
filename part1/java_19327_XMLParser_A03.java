import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_19327_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            parseXML("sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(String fileName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File file = new File(fileName);
        InputStream inputStream = new FileInputStream(file);

        Document document = builder.parse(inputStream);

        // Here you can handle the XML document safely
        // For instance, you could sanitize it by removing or modifying any script or code
        // Then print the sanitized XML to the console
        System.out.println(document.getDocumentElement().getNodeValue());
    }

}