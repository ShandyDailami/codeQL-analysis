import java.io.*;
import javax.xml.stream.*;

public class java_12212_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Read from a file
            XMLStreamReader reader = XMLStreamReaderFactory.createXMLStreamReader(new FileInputStream("input.xml"));
            // Write to a file
            XMLStreamWriter writer = XMLStreamWriterFactory.createXMLStreamWriter(new FileOutputStream("output.xml"));

            // Start the document
            writer.writeStartDocument("http://www.example.com/input", "UTF-8");

            // Begin processing of document
            while (reader.hasNext()) {
                int event = reader.nextEvent();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = reader.getLocalName();
                        writer.writeStartElement(elementName);
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        String text = reader.getText();
                        writer.writeCharacters(text);
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        writer.writeEndElement();
                        break;
                }
            }

            // End the document
            writer.writeEndDocument();

            // Close the stream
            writer.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}