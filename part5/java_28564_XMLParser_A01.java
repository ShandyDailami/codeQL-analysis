import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamToken;

public class java_28564_XMLParser_A01 {
    public static void main(String[] args) {
        String xml = "<root><element>Hello, World!</element></root>";
        parseXML(xml);
    }

    public static void parseXML(String xml) {
        XMLStreamReader reader = null;
        try {
            reader = XMLStreamReader.newReader(xml);
        } catch (XMLStreamException e1) {
            e1.printStackTrace();
        }

        while (reader.hasNext()) {
            XMLStreamToken token = reader.nextToken();
            switch (token.getTokenType()) {
                case START_ELEMENT:
                    System.out.println("Start of element: " + reader.getElementName());
                    break;
                case CHARACTERS:
                    System.out.println("Character data: " + reader.getText());
                    break;
                case END_ELEMENT:
                    System.out.println("End of element: " + reader.getElementName());
                    break;
            }
        }

        try {
            reader.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}