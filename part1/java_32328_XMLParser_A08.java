import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_32328_XMLParser_A08 {
    public static void main(String[] args) {
        XMLReader reader = null;
        DefaultHandler handler = new DefaultHandler();

        try {
            reader = SAXReader.newInstance();
            reader.setContentHandler(handler);
            reader.parse("src/legacy/input.xml");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    static class LegacySAXHandler extends DefaultHandler {
        @Override
        public void startDocument() {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes atts) {
            System.out.print("Start of " + qualifiedName);
            for (int i = 0; i < atts.getLength(); i++) {
                System.out.print(atts.getQualifiedPrefix(i) + "=" + atts.getValue(i));
            }
            System.out.println(" End of " + qualifiedName);
        }

        @Override
        public void endElement(String namespaceURI, String localName, String qualifiedName) {
            System.out.println("End of " + qualifiedName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String str = new String(ch, start, length);
            System.out.println("Characters: " + str);
        }

        @Override
        public void error(SAXException e) {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }

        @Override
        public void warning(SAXException e) {
            System.out.println("Warning: " + e.getMessage());
        }
    }
}