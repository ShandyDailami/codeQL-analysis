import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLErrorHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class java_10613_XMLParser_A03 {

    private static class MyHandler extends DefaultHandler {
        private List<String> tags;
        private String currentTag;

        public java_10613_XMLParser_A03(List<String> tags) {
            this.tags = tags;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            currentTag = qName;
            if(tags.contains(qName)) {
                System.out.println("Security warning: suspicious XML element: " + qName);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentTag = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if(currentTag != null && currentTag.equals(qName)) {
                System.out.println("Security warning: suspicious character data inside XML element: " + new String(ch, start, length));
            }
        }
    }

    public static void main(String[] args) {
        try {
            List<String> suspiciousTags = List.of("script", "style", "iframe", "embed", "applet", "param", "frame");
            File file = new File("path_to_your_xml_file.xml");
            XMLErrorHandler errorHandler = new MyHandler(suspiciousTags);
            XMLParser parser = new SAXParser(errorHandler);
            parser.parse(new FileInputStream(file), errorHandler);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}