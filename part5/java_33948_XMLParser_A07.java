import java.io.File;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_33948_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            XMLStreamReader reader = getXMLStreamReader("resources/sample.xml");

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

            reader.close();

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static XMLStreamReader getXMLStreamReader(String filePath) throws XMLStreamException {
        File inputFile = new File(filePath);
        return XMLStreamReaderFactory.createXMLStreamReader(inputFile);
    }
}