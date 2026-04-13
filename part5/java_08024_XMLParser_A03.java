import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.XMLReader;

public class java_08024_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyContentHandler());
            reader.parse("sample.xml"); // replace with your xml file
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyContentHandler implements ContentHandler {

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            System.out.println("Ignorable whitespace: " + new String(ch, start, length));
        }

        @Override
        public void processingInstruction(String target, String content) throws SAXException {
            System.out.println("Proc instruction: " + target + ", " + content);
        }

        @Override
        public void comment(char[] ch, int start, int length) throws SAXException {
            System.out.println("Comment: " + new String(ch, start, length));
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            System.out.println("Ignorable whitespace: " + new String(ch, start, length));
        }

        @Override
        public void endPrefixMapping(String prefix, String uri) throws SAXException {
            System.out.println("End prefix mapping: " + prefix + ", " + uri);
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            System.out.println("Start prefix mapping: " + prefix + ", " + uri);
        }
    }
}