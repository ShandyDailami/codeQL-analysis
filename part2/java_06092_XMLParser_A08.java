import org.apache.xml.parser.DOM;
import org.apache.xml.parser.DTD;
import org.apache.xml.parser.EntityResolver;
import org.apache.xml.parser.InputSource;
import org.apache.xml.parser.ParseException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.security.InvalidParameterException;

public class java_06092_XMLParser_A08 {
    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<root>\n" +
                "    <element1>Element 1 content</element1>\n" +
                "    <element2>Element 2 content</element2>\n" +
                "</root>";

        parseXML(xml);
    }

    public static void parseXML(String xml) {
        try {
            if (xml == null || xml.length() == 0) {
                throw new InvalidParameterException("xml cannot be null or empty");
            }

            InputSource is = new InputSource(new StringReader(xml));
            Document doc = parse(is);

            // No security-sensitive operations here.
            // The Document object is safe to use.

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static Document parse(InputSource input) throws IOException, ParseException {
        DOM.DOMReader domReader = DOM.readDOMFromInputStream(input.getByteStream());
        return createDocument(domReader);
    }

    public static Document createDocument(DOM.DOMReader reader) {
        EntityResolver entityResolver = new EntityResolver() {
            public InputSource resolveEntity(String publicId, String systemId) throws IOException, SAXException {
                // We do not resolve entities.
                return new InputSource(new StringReader(""));
            }
        };

        return new Document(reader, entityResolver);
    }
}