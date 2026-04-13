import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_42166_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFilePath = "path/to/your/xml/file";
        readXMLFile(xmlFilePath);
    }

    private static void readXMLFile(String xmlFilePath) {
        try {
            File xmlFile = new File(xmlFilePath);
            if (!xmlFile.exists()) {
                System.out.println("XML file not found");
                return;
            }

            FileInputStream fis = new FileInputStream(xmlFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fis);

            // parse the content of the file
            printXmlFile(doc);

            fis.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("Error configuration: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAX exception: " + e.getMessage());
        }
    }

    private static void printXmlFile(Document doc) {
        // Implement your logic here
    }
}