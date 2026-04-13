import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_28819_XMLParser_A03 {

    public static void main(String[] args) throws Exception {
        File xmlFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        saxParser.parse(xmlFile, new MyHandler("data"));
    }

    static class MyHandler implements javax.xml.parsers.SAXHandler {
        private String tag;
        private boolean flag;

        public java_28819_XMLParser_A03(String tag) {
            this.tag = tag;
            flag = false;
        }

        public void startElement(String uri, String localName, String qName,
                                 javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
            if (qName.equals(this.tag)) {
                flag = true;
            }
        }

        public void endElement(String uri, String localName, String qName)
                throws javax.xml.parsers.SAXException {
            if (qName.equals(this.tag)) {
                flag = false;
            }
        }

        public void characters(char[] ch, int start, int length)
                throws javax.xml.parsers.SAXException {
            if (flag) {
                System.out.println(new String(ch, start, length));
            }
        }
    }
}