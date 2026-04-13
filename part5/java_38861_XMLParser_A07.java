import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamConstants;

public class java_38861_XMLParser_A07 {
    public static void main(String[] args) {
        String xml = "<person>\n" +
                "  <name>John</name>\n" +
                "  <age>30</age>\n" +
                "  <city>New York</city>\n" +
                "</person>";

        parseXml(xml);
    }

    private static void parseXml(String xml) {
        try {
            XMLStreamReader streamReader = XMLStreamReader.newReader(xml.getBytes());
            XMLStreamWriter streamWriter = XMLStreamWriter.newWriter(System.out);

            streamWriter.writeStartDocument("UTF-8", "1.0");
            streamWriter.writeStartElement("root");

            String elementName = "";
            while (streamReader.hasNext()) {
                int type = streamReader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        elementName = streamReader.getLocalName();
                        streamWriter.writeStartElement(elementName);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        streamWriter.writeCharacters(streamReader.getText());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = streamReader.getLocalName();
                        streamWriter.writeEndElement();
                        break;
                }
            }

            streamWriter.writeEndDocument();
            streamWriter.flush();
            streamWriter.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}