import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;
import org.xml.sax.parser.XMLEventHandler;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.Xerces2SAXParser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class java_22825_XMLParser_A01 {
    private List<String> tags = new ArrayList<>();
    private List<String> values = new ArrayList<>();

    public java_22825_XMLParser_A01(List<String> tags, List<String> values) {
        this.tags = tags;
        this.values = values;
    }

    public void parse(InputStream inputStream) throws IOException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(new XMLErrorHandler() {
            @Override
            public void error(SAXParseException e) throws SAXException {
                throw e;
            }

            @Override
            public void fatalError(SAXParseException e) throws SAXException {
                throw e;
            }

            @Override
            public void warning(SAXParseException e) {
                // Ignore warnings for security
            }
        });

        Xerces2SAXParser saxParser = (Xerces2SAXParser) parser;
        saxParser.setProperty(Xerces2SAXParser.XERCES2_XML_PARSER, true);

        SAXEventHandler eventHandler = new SAXEventHandler() {
            @Override
            public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
                for (String tag : tags) {
                    if (localName.equalsIgnoreCase(tag)) {
                        String value = attributes.getValue(0);
                        values.add(value);
                    }
                }
            }

            @Override
            public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
                // Not implemented
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                // Not implemented
            }
        };

        parser.setProperty("http://xml.org/sax/features", "all");
        parser.setProperty("http://xml.org/sax/namespaces", "all");
        parser.setProperty("http://xml.org/sax/properties/lexical", "true");
        parser.setProperty("http://xml.org/sax/properties/case-insensitive", "true");
        parser.setProperty("http://xml.org/sax/properties/source-uri", "true");

        XMLParser xmlParser = parser.getUnderlyingParser();
        xmlParser.setContentHandler(eventHandler);

        xmlParser.parse(inputStream);
    }
}