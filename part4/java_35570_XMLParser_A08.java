import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

import java.util.ArrayList;
import java.util.List;

public class java_35570_XMLParser_A08 extends DefaultHandler {

    private List<String> tags;
    private String currentTag;
    private StringBuilder content;

    public java_35570_XMLParser_A08() {
        this.tags = new ArrayList<>();
        this.content = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        this.currentTag = qName;
        this.tags.add(qName);
        this.content.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        this.content.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (this.tags.contains(this.currentTag)) {
            // Process the security-sensitive operation here
            // For simplicity, we just print out the content
            System.out.println("Security-sensitive operation for tag: " + this.currentTag + ", content: " + this.content.toString());

            // Reset for next element
            this.tags.remove(this.currentTag);
            this.currentTag = null;
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        String xmlFile = "src/main/resources/sample.xml";

        SAXHelper saxHelper = new SAXHelper();
        saxHelper.setContentHandler(new SecuritySAXHandler());
        saxHelper.parse(xmlFile);
    }
}