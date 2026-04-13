import java.io.StringReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamToken;

public class java_26799_XMLParser_A08 {
    public static void main(String[] args) {
        String xml = "<person><name>John</name><city>New York</city></person>";

        try {
            XMLStreamReader reader = new XMLStreamReader(new StringReader(xml));

            while (reader.hasNext()) {
                XMLStreamToken token = reader.nextToken();

                switch (token.getTokenType()) {
                    case START_DOCUMENT:
                        System.out.println("Start of document");
                        break;
                    case START_ELEMENT:
                        System.out.println("Start of element: " + reader.getLocalName());
                        break;
                    case CHARACTERS:
                        System.out.print(reader.getText());
                        break;
                    case END_ELEMENT:
                        System.out.println("End of element: " + reader.getLocalName());
                        break;
                    case END_DOCUMENT:
                        System.out.println("End of document");
                        break;
                }
            }

            reader.close();

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}