import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamConstants;

public class java_15338_XMLParser_A08 {

    public static void parseXML(String xmlFilePath) {
        XMLStreamReader reader;

        try {
            reader = XMLStreamReader.newReader(xmlFilePath);
            System.out.println("Parsing XML document in a stream manner...");

            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = reader.getLocalName();
                        System.out.println("Start Element: " + elementName);
                        if (elementName.equals("student")) {
                            int studentId = Integer.parseInt(reader.getAttributeValue(null, "id"));
                            String studentName = reader.getElementText();
                            System.out.println("ID: " + studentId);
                            System.out.println("Name: " + studentName);
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = reader.getLocalName();
                        System.out.println("End Element: " + elementName);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String charText = reader.getText();
                        System.out.println("Characters: " + charText);
                        break;
                    default:
                        break;
                }
            }
            reader.close();

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parseXML("src/main/resources/students.xml");
    }
}