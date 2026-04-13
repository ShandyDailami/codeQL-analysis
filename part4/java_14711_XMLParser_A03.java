import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.SAXEntityResolver;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.util.List;

public class java_14711_XMLParser_A03 {
    private List<String> entities;

    public java_14711_XMLParser_A03(List<String> entities) {
        this.entities = entities;
    }

    public void parse(InputStream inputStream, DefaultHandler handler) throws SAXException {
        SAXEntityResolver entityResolver = new SAXEntityResolver() {
            @Override
            public InputStream resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                if (entities.contains(systemId)) {
                    throw new SAXException("Entity " + systemId + " is disallowed");
                }
                return null;
            }
        };

        XMLReader reader = XMLReaderFactory.createXMLReader(handler, entityResolver);
        reader.parse(new InputSource(inputStream));
    }
}