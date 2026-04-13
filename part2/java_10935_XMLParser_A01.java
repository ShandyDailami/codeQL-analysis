import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_10935_XMLParser_A01 {

    public void parseXML(XMLStreamReader reader) throws XMLStreamException {
        int event;

        while (reader.hasNext()) {
            event = reader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    String elementName = reader.getLocalName();
                    System.out.println("Start element: " + elementName);
                    break;

                case XMLStreamConstants.CHARACTERS:
                    String character = reader.getText();
                    System.out.println("Character data: " + character);
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.println("End element: " + elementName);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        // Create a StreamFactory and a StreamReader
        XMLStreamReader reader = XMLStreamConstants.createXMLEStreamReader(new StringReader("<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>"));

        // Parse XML
        XMLParser xmlParser = new XMLParser();
        try {
            xmlParser.parseXML(reader);
        } finally {
            reader.close();
        }
    }
}