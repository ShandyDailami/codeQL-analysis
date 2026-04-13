import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_38194_XMLParser_A01 {
    public static void parse(String xmlFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(xmlFile, new InputSource(new File(xmlFile)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bAccessControl = false;
        boolean bXmlDeclaration = false;

        @Override
        public void startDocument() {
            bAccessControl = true;
            bXmlDeclaration = true;
        }

        @Override
        public void startElement(String uri, String localName, String qName) throws SAXException {
            if (bAccessControl) {
                System.out.println("Found access control: " + qName);
                bAccessControl = false;
            } else if (bXmlDeclaration) {
                System.out.println("Found XML declaration: " + qName);
                bXmlDeclaration = false;
            }
        }
    }

    public static void main(String[] args) {
        XMLParser.parse("accessControl.xml");
    }
}