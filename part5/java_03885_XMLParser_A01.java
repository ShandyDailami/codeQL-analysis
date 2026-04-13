import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.DefaultHandler;
import org.xml.sax.helpers.DefaultHandlerSupplier;
import java.io.File;
import java.io.IOException;

public class java_03885_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();
            DefaultHandlerSupplier supplier = new DefaultHandlerSupplier(new DefaultHandler() {
                public void startDocument() throws SAXException {
                    System.out.println("Start of document");
                }

                public void endDocument() throws SAXException {
                    System.out.println("End of document");
                }

                public void startElement(String uri, String localName, String qName,
                        org.xml.sax.Attributes attributes) throws SAXException {
                    System.out.print("Start of " + qName);
                }

                public void endElement(String uri, String localName, String qName)
                        throws SAXException {
                    System.out.println("End of " + qName);
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    String content = new String(ch, start, length);
                    System.out.println("Content: " + content);
                }
            });

            reader.setContentHandler(supplier.getContentHandler());
            reader.setEntityResolver(supplier.getEntityResolver());
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}