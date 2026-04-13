import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;

public class java_35621_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "path_to_your_xml_file";
        parseXMLFile(xmlFile);
    }

    public static void parseXMLFile(String file) {
        XMLStreamReader reader = null;
        try {
            reader = XMLStreamReader.newInstance(file);
            printElements(reader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    private static void printElements(XMLStreamReader reader) throws XMLStreamException {
        String elementName;
        while (reader.hasNext()) {
            elementName = reader.nextName();
            switch (reader.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    System.out.println("Start of element: " + elementName);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    System.out.print("Character data: " + reader.getText());
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    System.out.println("End of element: " + elementName);
                    break;
            }
        }
    }
}