import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLFilter;
import org.xml.sax.ext.LimitedDOMHandler;

public class java_38603_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlContent = "<note>\n" +
                "    <to>Tove</to>\n" +
                "    <from>Jani</from>\n" +
                "    <heading>Reminder</heading>\n" +
                "    <body>Don't forget me this weekend!</body>\n" +
                "</note>";

        // Create a new SAX parser with a limited DOM handler
        XMLReader xr = XMLReaderFactory.createXMLReader();
        xr.setContentHandler(new DefaultHandler());
        xr.setEntityResolver(new XMLFilter(new LimitedDOMHandler(new DefaultHandler())));

        try {
            xr.parse("data://application/xml," + xmlContent);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}