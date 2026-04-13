import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_35954_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            File inputFile = new File("src/myfile.xml");
            saxParser.parse(inputFile, MyHandler.getDefaultHandlerInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;
        private String qName = "";
        private int depth = 0;

        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            this.qName = qName;
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Start of person");
                bName = true;
                bAge = true;
            } else if (bName && qName.equalsIgnoreCase("name")) {
                System.out.println("Start of name");
                bName = false;
            } else if (bName && qName.equalsIgnoreCase("age")) {
                System.out.println("Start of age");
                bAge = false;
            }
        }

        @Override
        public java_35954_XMLParser_A01(String uri, String localName, String qName) {
            if (qName.equalsIgnoreCase(this.qName)) {
                System.out.println("End of " + this.qName);
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bName || bAge) {
                System.out.println("Character data : " + new String(ch, start, length));
                if (bName)
                    bName = false;
                else if (bAge)
                    bAge = false;
            }
        }

        public static DefaultHandler getDefaultHandlerInstance() {
            return new DefaultHandler() {
                @Override
                public void startDocument() {
                    // do nothing
                }

                @Override
                public void endDocument() {
                    // do nothing
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    // do nothing
                }

                @Override
                public void endElement(String uri, String localName, String qName) {
                    // do nothing
                }

                @Override
                public void characters(char[] ch, int start, int length) {
                    // do nothing
                }
            };
        }
    }
}