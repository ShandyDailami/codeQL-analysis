// This program parses an XML file using the XMLStream API. It will print out the names of all the tags in the file, and their content.

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_13093_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create an instance of XMLStreamReader to read the XML file.
            XMLStreamReader reader = createXMLStreamReader();

            // Parse the XML file.
            parseXMLFile(reader);

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static XMLStreamReader createXMLStreamReader() throws XMLStreamException {
        // Define the input file.
        File inputFile = new File("legacy.xml");

        // Create an instance of XMLStreamReader to read the XML file.
        XMLStreamReader reader = XMLStreamConstants.getXMLEventFactory().createXMLStreamReader(inputFile);

        return reader;
    }

    private static void parseXMLFile(XMLStreamReader reader) throws XMLStreamException {
        int event;
        while (reader.hasNext()) {
            event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    System.out.println("Start element: " + reader.getLocalName());
                    break;
                case XMLStreamConstants.CHARACTERS:
                    System.out.print("Character data: " + reader.getText());
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    System.out.println("End element: " + reader.getLocalName());
                    break;
            }
        }
    }
}