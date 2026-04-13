import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_09055_XMLParser_A01 {
    private SAXParser saxParser;

    public java_09055_XMLParser_A01() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        this.saxParser = saxParserFactory.newSAXParser();
    }

    public void parseXmlFile(String filePath) {
        File xmlFile = new File(filePath);
        XMLHandler xmlHandler = new XMLHandler();
        saxParser.parse(xmlFile, xmlHandler);
    }

    private static class XMLHandler extends DefaultHandler {
        private boolean isName = false;
        private boolean isValue = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("name")) {
                isName = true;
            } else if (qName.equals("value")) {
                isValue = true;
            }
        }

        @Override
        public void characters(char[] chars, int start, int length) {
            if (isName) {
                System.out.println("Name: " + new String(chars, start, length));
                isName = false;
            } else if (isValue) {
                System.out.println("Value: " + new String(chars, start, length));
                isValue = false;
            }
        }
    }
}