import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_00705_XMLParser_A01 {

    public static void parseXML(XMLStreamReader reader) throws XMLStreamException {
        int event;
        while(reader.hasNext()) {
            event = reader.next();
            switch(event) {
                case XMLStreamConstants.START_ELEMENT:
                    if(reader.getLocalName().equals("book")) {
                        String id = reader.getAttributeValue(null, "id");
                        String title = reader.getElementText();
                        System.out.println("Book id: " + id + ", Title: " + title);
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        XMLStreamReader reader = XMLParserLegacy.createXMLStreamReader();
        parseXML(reader);
    }

    public static XMLStreamReader createXMLStreamReader() {
        // Assuming that we have an XML file at 'path'
        String path = "books.xml";
        XMLStreamReader reader = null;
        try {
            reader = XMLParserLegacy.createXMLStreamReader(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reader;
    }

    public static XMLStreamReader createXMLStreamReader(String path) {
        return XMLParserLegacy.createXMLStreamReader(new FileInputStream(path));
    }

    public static XMLStreamReader createXMLStreamReader(InputStream input) {
        return XMLParserLegacy.createXMLStreamReader(new InputStreamReader(input));
    }

    public static XMLStreamReader createXMLStreamReader(Reader reader) {
        return new XMLStreamReaderImpl(reader);
    }
}