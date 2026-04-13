import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_06841_XMLParser_A03 {
    public static void main(String[] args) {
        String inputFile = "src/input.xml";
        String outputFile = "src/output.txt";

        SAXParserFactory parserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = parserFactory.newSAXParser(null, new Handler());
            parser.parse(inputFile, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Handler extends DefaultHandler {
        private boolean bTitle = false;
        private boolean bLink = false;
        private StringBuffer buffer = new StringBuffer();

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                bTitle = true;
            } else if (qName.equalsIgnoreCase("link")) {
                bLink = true;
            }
            buffer.append("<").append(qName);
            for (int i = 0; i < attributes.getLength(); i++) {
                buffer.append(" ").append(attributes.getQName(i)).append("=").append(attributes.getValue(i));
            }
            buffer.append(">");
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            buffer.append("</").append(qName).append(">");
            if (bTitle) {
                bTitle = false;
                System.out.println("Title: " + buffer.toString());
                buffer.setLength(0);
            } else if (bLink) {
                bLink = false;
                System.out.println("Link: " + buffer.toString());
                buffer.setLength(0);
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTitle || bLink) {
                buffer.append(ch, start, length);
            }
        }
    }
}