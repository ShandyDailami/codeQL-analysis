import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_18218_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("sensitive.xml"); // replace with your XML file path
        if (!xmlFile.exists()) {
            System.out.println("File not found!");
            return;
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;

        try {
            document = builder.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return;
        }

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(saxParserFactory.getCharacterEncodingFeature());

        // use a custom SAXHandler to handle the XML data
        saxParser.setContentHandler(new SensitiveContentHandler());

        // parse the XML file
        saxParser.parse(document.getDocumentElement().getFirstChild().getNextSibling());
    }
}