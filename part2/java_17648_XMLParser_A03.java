import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.io.*;

public class java_17648_XMLParser_A03 {

    public static void main(String[] args) throws XMLStreamException {
        XMLStreamReader reader = createXMLStreamReader();
        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            if (event.getEventType() == XMLEvent.START_ELEMENT) {
                String element = event.asStartElement().getElementLocalName();
                if ("injection".equals(element)) {
                    // Here we are injecting a security-related operation
                    // For example, we are disabling all the XMLStreamConstants
                    reader.nextTag();
                    reader.nextTag();
                }
            }
        }
        reader.close();
    }

    private static XMLStreamReader createXMLStreamReader() throws XMLStreamException {
        XMLInputFactory factory = new XMLStreamReaderFactory();
        InputStream stream = getClass().getResourceAsStream("/data.xml");
        return factory.createXMLStreamReader(stream, new UnescapedCharacterReplacementHandler());
    }

    // This is an example of a UnescapedCharacterReplacementHandler.
    // You should replace it with your own implementation.
    private static class UnescapedCharacterReplacementHandler implements UnescapedCharacterReplacement {
        @Override
        public String getReplacement(String s) {
            return s;
        }
    }
}