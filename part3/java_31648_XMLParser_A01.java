import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_31648_XMLParser_A01 {

    public static void main(String[] args) {
        String fileName = "sample.xml";  // your xml file name

        File inputFile = new File(fileName);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;

        try {
            doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            System.out.println("XML file was successfully parsed.");

        } catch (SAXException e) {
            System.out.println("Error: XML file was not parsed.");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Error: Unable to read the XML file.");
            e.printStackTrace();
        }
    }
}