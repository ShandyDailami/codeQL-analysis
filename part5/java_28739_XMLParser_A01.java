import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_28739_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            XMLErrorHandler errorHandler = new XMLErrorHandler() {
                @Override
                public void error(SAXParseException e) {
                    System.out.println("Error parsing XML: " + e.getMessage());
                }

                @Override
                public void fatalError(SAXParseException e) {
                    System.out.println("Fatal error parsing XML: " + e.getMessage());
                }

                @Override
                public void warning(SAXParseException e) {
                    System.out.println("Warning parsing XML: " + e.getMessage());
                }
            };

            saxParser.setErrorHandler(errorHandler);
            saxParser.parse("src/main/resources/sample.xml", new XMLHandler());
        } catch (Exception e) {
            System.out.println("Error creating SAXParser: " + e.getMessage());
        }
    }

    static class XMLHandler implements SAXHandler {
        private boolean accessControl = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("access")) {
                accessControl = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equals("access")) {
                accessControl = false;
            }
        }

        @Override
        public boolean startPrefixMapping(String prefix, String uri) {
            return false;
        }

        @Override
        public void endPrefixMapping(String prefix) {
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (accessControl) {
                System.out.println("Access control violation detected in XML: " + new String(ch, start, length));
            }
        }
    }
}