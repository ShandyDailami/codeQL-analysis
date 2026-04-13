import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_01093_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFilePath = "your_xml_file_path.xml"; // replace with your XML file path
        validateXmlFile(xmlFilePath);
    }

    public static void validateXmlFile(String xmlFilePath) {
        try {
            File xmlFile = new File(xmlFilePath);
            InputStream inputStream = new FileInputStream(xmlFile);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);
            inputStream.close();
            System.out.println("The XML file is valid");
        } catch (Exception e) {
            System.out.println("The XML file is not valid");
            e.printStackTrace();
        }
    }
}