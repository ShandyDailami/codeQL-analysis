import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_26744_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        File outputFile = new File("output.xml");

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(new org.xml.sax.InputSource(new java.io.StringReader(doc.getElements().toString())));

            SAXHandler saxHandler = new SAXHandler();
            saxParser.setContentHandler(saxHandler);
            saxParser.parse(new java.io.InputStreamReader(new java.io.ByteArrayInputStream(doc.getElements().toString().getBytes())));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}