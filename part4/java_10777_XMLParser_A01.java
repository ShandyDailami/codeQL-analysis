import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;

public class java_10777_XMLParser_A01 extends DefaultHandler {

    private boolean bAccessControl = false;

    public java_10777_XMLParser_A01() {
        super();
    }

    public void startDocument() {
        bAccessControl = true;
    }

    public void startElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("access")) {
            bAccessControl = false;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("access")) {
            bAccessControl = true;
        }
    }

    public void endDocument() {
        if (bAccessControl) {
            throw new SecurityException("Broken access control!");
        }
    }

    public static void main(String[] args) {
        File inputFile = new File("accessControlFile.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(new InputSource(new FileInputStream(inputFile)));
            BrokenAccessControlParser handler = new BrokenAccessControlParser();
            saxParser.parse(inputFile, handler);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("Security violation: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}