import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;

public class java_32930_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/sample.xml";
        parseXMLFile(xmlFile);
    }

    public static void parseXMLFile(String xmlFile) {
        XMLStreamReader reader = null;
        try {
            reader = XMLStreamReader.newInstance(xmlFile);
            String elementName = null;
            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    elementName = reader.getLocalName();
                    System.out.println("Start of element: " + elementName);
                } else if (event == XMLStreamConstants.END_ELEMENT) {
                    System.out.println("End of element: " + elementName);
                } else if (event == XMLStreamConstants.CHARACTERS) {
                    String text = reader.getText();
                    System.out.println("Text: " + text);
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