import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.XMLSecurity;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class java_16576_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            String data = "<document>Your XML data here</document>"; // Replace with your XML data
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(new DefaultHandler());

            InputStream is = new ByteArrayInputStream(data.getBytes());
            XMLReader xr = XMLReaderFactory.createXMLReader();

            XMLSecurity s = XMLSecurity.newSecurityHandler(new DefaultHandler(), is);
            s.setValidate(true);
            s.setErrorHandler(new DefaultHandler());

            sp.parse(is, s);

            System.out.println("Parse successful");

        } catch (Exception e) {
            System.out.println("Parse failed: " + e.getMessage());
        }
    }
}