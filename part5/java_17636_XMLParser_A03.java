import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_17636_XMLParser_A03 {

    public static void main(String[] args) throws Exception {
        File inputFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(false);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(inputFile, myHandler);
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder sb;
        private boolean isName;
        private boolean isText;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            sb = new StringBuilder();
            if(qName.equals("name")) {
                isName = true;
            }
            if(qName.equals("text")) {
                isText = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if(isName) {
                // Process the name
                System.out.println("Name: " + new String(ch, start, length));
                isName = false;
            } else if(isText) {
                // Process the text
                System.out.println("Text: " + new String(ch, start, length));
                isText = false;
            }
        }
    }
}