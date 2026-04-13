import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_30796_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            XMLReader parser = XMLReaderFactory.createXMLReader();
            parser.setContentHandler(new SAXContentHandler(new DefaultHandler() {
                public void startElement(String uri, String localName, String qName)
                        throws SAXException {
                    if (qName.equals("auth")) {
                        // Here you should handle the security sensitive operations
                        // related to A07_AuthFailure
                    }
                }
            }));
            parser.parse(new InputSource(new StringReader("<root><auth/></root>")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}