import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class java_32462_XMLParser_A07 {

    public static class MyHandler extends DefaultHandler {
        private boolean bNodeFound = false;
        private String thisNode = "";
        private String thisValue = "";

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            bNodeFound = true;
            thisNode = qName;
            thisValue = "";
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            bNodeFound = false;
       
            if(this.thisNode.equals("AuthFailure")) {
                System.out.println("Security sensitive operation detected in: " + thisValue);
            }
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bNodeFound) {
                thisValue = new String(ch, start, length);
            }
        }
    }

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\"?>\n" +
                "<AuthFailure>\n" +
                "<id>1234</id>\n" +
                "<desc>This is a security sensitive operation.</desc>\n" +
                "</AuthFailure>\n" +
                "<AnotherAuthFailure>\n" +
                "<id>5678</id>\n" +
                "<desc>This is another security sensitive operation.</desc>\n" +
                "</AnotherAuthFailure>\n" +
                "</AuthFailure>";
        
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}