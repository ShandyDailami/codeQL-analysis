import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_15463_XMLParser_A01 extends DefaultHandler {
    private boolean isTitle = false;
    private boolean isLink = false;
    private boolean isDescription = false;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("title")) {
            isTitle = true;
        } else if (qName.equals("link")) {
            isLink = true;
        } else if (qName.equals("description")) {
            isDescription = true;
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("title")) {
            isTitle = false;
        } else if (qName.equals("link")) {
            isLink = false;
        } else if (qName.equals("description")) {
            isDescription = false;
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isTitle) {
            String title = new String(ch, start, length);
            // Do something with the title
        } else if (isLink) {
            String link = new String(ch, start, length);
            // Do something with the link
        } else if (isDescription) {
            String description = new String(ch, start, length);
            // Do something with the description
        }
    }
}

public class MyXMLParser {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String xml = "<bookstore>\n" +
                "  <book category='tutorial'>\n" +
                "    <title>Introduction to Java</title>\n" +
                "    <link>www.javaworld.com</link>\n" +
                "    <description>First book in the series. An introduction to the Java language and programming.\n" +
                "    </description>\n" +
                "  </book>\n" +
                "</bookstore>";
        
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        
        MyXMLHandler handler = new MyXMLHandler();
        parser.parse(new InputSource(new StringReader(xml)), handler);
    }
}