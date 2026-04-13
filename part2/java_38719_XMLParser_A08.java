import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXParserHelper;
import org.xml.sax.xmlreader.XMLReader;
import org.xml.sax.xmlreader.XMLStreamException;
import org.xml.sax.xmlreader.XMLStreamReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class java_38719_XMLParser_A08 {
    private File file;
    private DefaultHandler defaultHandler;
    private SAXParserHelper saxParserHelper;

    public java_38719_XMLParser_A08(File file, DefaultHandler defaultHandler) {
        this.file = file;
        this.defaultHandler = defaultHandler;
        this.saxParserHelper = new SAXParserHelper();
    }

    public void parse() {
        XMLStreamReader streamReader = null;
        try {
            streamReader = new XMLStreamReader(new FileReader(file));
            saxParserHelper.setXMLStreamReader(streamReader);
            saxParserHelper.setContentHandler(defaultHandler);
            saxParserHelper.startDocument();
            while (saxParserHelper.getEventType() != XMLStreamReader.END_DOCUMENT) {
                saxParserHelper.nextTag();
            }
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        } finally {
            if (streamReader != null) {
                try {
                    streamReader.close();
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}