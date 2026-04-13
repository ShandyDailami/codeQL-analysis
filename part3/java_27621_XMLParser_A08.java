import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_27621_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a File
            File file = new File("path_to_your_xml_file.xml");
            // Create an InputStream
            InputStream inputStream = new FileInputStream(file);
            // Parse the file into a Document
            Document document = builder.parse(inputStream);

            // Now you can manipulate the XML document as needed

            inputStream.close();
        } catch (ParserConfigurationException | SAXException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}