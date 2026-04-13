import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;

public class java_32918_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "src/main/resources/example.xml";
        parseXMLFile(xmlFile);
    }

    private static void parseXMLFile(String xmlFile) {
        XMLStreamReader reader = null;
        try {
            reader = XMLStreamReader.newReader(getClass().getResourceAsStream(xmlFile));
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("Start element: " + reader.getLocalName());
                        break;
                    case XMLStreamConstants.COMMENT:
                        System.out.println("Comment: " + reader.getLocalName());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("End element: " + reader.getLocalName());
                        break;
                    default:
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}