import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

public class java_07809_XMLParser_A03 {

    private final Set<String> allowedTags;
    private final Set<String> allowedAttributes;
    private final DefaultHandler defaultHandler;

    public java_07809_XMLParser_A03(Set<String> allowedTags, Set<String> allowedAttributes) {
        this.allowedTags = allowedTags;
        this.allowedAttributes = allowedAttributes;
        this.defaultHandler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (!allowedTags.contains(qName)) {
                    throw new SAXException("Tag not allowed: " + qName);
                }
                if (attributes != null) {
                    for (int i = 0; i < attributes.getLength(); i++) {
                        if (!allowedAttributes.contains(attributes.getQualifiedPrefix(i) + ":" + attributes.getLocalName(i))) {
                            throw new SAXException("Attribute not allowed: " + attributes.getQualifiedName(i));
                        }
                    }
                }
            }
        };
    }

    public void parse(String xmlFilePath) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(new InputSource(new File(xmlFilePath)));
        saxParser.parse(new File(xmlFilePath), defaultHandler);
    }
}