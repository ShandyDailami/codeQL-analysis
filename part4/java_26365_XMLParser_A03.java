import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_26365_XMLParser_A03 {

    public static Document parseXMLFile(String filePath) throws IOException, SAXException {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        return doc;
    }

    public static void main(String[] args) throws IOException, SAXException {
        Document doc = parseXMLFile("path_to_your_xml_file");
        // Now, you can safely manipulate the XML document without worrying about security issues
    }
}