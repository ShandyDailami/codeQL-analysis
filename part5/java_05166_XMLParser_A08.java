import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_05166_XMLParser_A08 {

    public static void parseXMLFile(String filePath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(new File(filePath), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder builder;
        private boolean tagContent;

        @Override
        public void startDocument() {
            builder = new StringBuilder();
            tagContent = false;
        }

        @Override
        public void endDocument() {
            // Do nothing
        }

        @Override
        public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) {
            builder.append("<").append(qualifiedName);
            for (int i = 0; i < attributes.getLength(); i++) {
                builder.append(" ").append(attributes.getQualifiedName(i)).append("=\"").append(attributes.getValue(i)).append("\"");
            }
            builder.append(">");
            tagContent = true;
        }

        @Override
        public void endElement(String uri, String localName, String qualifiedName) {
            if (tagContent) {
                builder.append("</").append(qualifiedName).append(">");
                tagContent = false;
            }
            System.out.println(builder.toString());
            builder.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (tagContent) {
                builder.append(new String(ch, start, length));
            }
        }
    }
}