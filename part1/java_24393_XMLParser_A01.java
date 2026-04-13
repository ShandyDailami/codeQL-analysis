import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_24393_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file");
            FileInputStream fis = new FileInputStream(xmlFile);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fis);
            doc.getDocumentElement().normalize();

            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new org.xml.sax.InputSource(new StringReader(doc.getCharacterEncoding())));

            SaxHandler saxHandler = new SaxHandler();
            saxParser.parse(doc, saxHandler);

            System.out.println("Access Level: " + saxHandler.getAccessLevel());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SaxHandler implements org.xml.sax.helpers.DefaultHandler {
    private String accessLevel = null;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("file")) {
            if (attributes.getLength() > 0) {
                accessLevel = attributes.getValue("accessLevel");
            }
        }
    }

    public String getAccessLevel() {
        return accessLevel;
    }
}