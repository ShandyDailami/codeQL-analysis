import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_36053_XMLParser_A01 {
    public static void parseXML(XMLStreamReader reader) throws XMLStreamException {
        String elementName;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.println("Start element: " + elementName);
                    break;
                case XMLStreamConstants.COMMENT:
                    System.out.println("Comment: " + reader.getText());
                    break;
                case XMLStreamConstants.DOCUMENT:
                    System.out.println("Document");
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.println("End element: " + elementName);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        // Create a XMLStreamReader object
        XMLStreamReader reader = XMLStreamReader.newReader(System.in);

        try {
            parseXML(reader);
        } finally {
            reader.close();
        }
    }
}