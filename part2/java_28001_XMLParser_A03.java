import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.StringReader;
import java.io.File;

public class java_28001_XMLParser_A03 {
    private static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                                 javax.xml.namespace.QName qn, org.xml.sax.Attributes atts)
                throws SAXException {
            if (qName.equals("code")) {
                String code = atts.getValue("type");
                // Use a security-sensitive operation to remove the code
                System.out.println(removeCode(code));
            }
        }

        private String removeCode(String code) {
            // This is a security-sensitive operation that removes code
            return code;
        }
    }

    public static void main(String[] args) throws Exception {
        String xml = "<root><code type='code1'>code1</code><code type='code2'>code2</code></root>";
        parse(xml);
    }

    private static void parse(String xml) throws Exception {
        org.xml.sax.SAXException exception;
        XMLReader xreader;
        MyHandler handler = new MyHandler();
        xreader = XMLReaderFactory.createXMLReader();
        xreader.setContentHandler(handler);
        xreader.parse(new StringReader(xml));
    }
}