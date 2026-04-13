import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_17142_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            parse(inputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parse(File inputFile) throws ParserConfigurationException, SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        // Parse the file
        Document doc = dBuilder.parse(new FileInputStream(inputFile));

        // Print the parsed information
        System.out.println("XML File Parsed Successfully");
    }
}