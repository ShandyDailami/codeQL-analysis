import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class java_23478_XMLParser_A03 {

    public static void main(String[] args) {
        try (XMLStreamReader reader = new XMLStreamReader(new FileReader("input.xml"))) {
            XMLStreamWriter writer = new XMLStreamWriter(new FileWriter("output.xml"));
            parse(reader, writer);
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static void parse(XMLStreamReader reader, XMLStreamWriter writer) throws XMLStreamException {
        String elementName = "";
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = reader.getLocalName();
                    writer.writeStartElement(elementName);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText();
                    writer.writeCharacters(text);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = reader.getLocalName();
                    writer.writeEndElement();
                    break;
            }
        }
        writer.flush();
    }
}