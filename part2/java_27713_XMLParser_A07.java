import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_27713_XMLParser_A07 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: MyXMLParser <xmlfile>");
            System.exit(1);
        }

        String xmlFile = args[0];

        // check if xmlFile exists
        File file = new File(xmlFile);
        if (!file.exists()) {
            System.out.println("XML file does not exist!");
            System.exit(1);
        }

        // parse xml file
        try {
            parseXmlFile(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXmlFile(String xmlFile) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File(xmlFile));

        // print out XML file elements and attributes
        doc.getElementsByTagName("*").item(0).getNodeName();

        System.out.println("XML Parsing Succesful");
    }
}