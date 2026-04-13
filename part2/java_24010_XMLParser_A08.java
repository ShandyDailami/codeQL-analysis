import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_24010_XMLParser_A08 {

    public static void parse(XMLStreamReader reader) throws XMLStreamException {
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    System.out.println("Start element: " + name);
                    break;
                case XMLStreamConstants.COMMENT:
                    String comment = reader.getComment();
                    System.out.println("Comment: " + comment);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    System.out.println("End element: " + name);
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) throws XMLStreamException {
        String xml = "<person><name>John</name><age>30</age><city>New York</city></person>";
        XMLStreamReader reader = XMLStreamConstants.createXMLEventReader(xml);
        parse(reader);
    }
}