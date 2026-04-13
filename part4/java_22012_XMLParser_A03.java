import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_22012_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");
        parseFile(xmlFile);
    }

    private static void parseFile(File xmlFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse(xmlFile, SAXHandler.getHandler());
        } catch (SAXParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class SAXHandler extends DefaultHandler {
        private static final String INJECTION_PATTERN = "A03_Injection";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.contains(INJECTION_PATTERN)) {
                System.out.println("Detected injection attempt in: " + qName);
            }
        }

        public static DefaultHandler getHandler() {
            return new SAXHandler();
        }
    }
}