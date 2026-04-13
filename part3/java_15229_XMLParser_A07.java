import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_15229_XMLParser_A07 {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("src/main/resources/authFailure.xml")) {
            XMLStreamReader reader = XMLStreamReader.newInstance(input);
            parseXML(reader);
        } catch (FileNotFoundException | XMLStreamException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void parseXML(XMLStreamReader reader) throws XMLStreamException {
        String elementName;
        while (reader.hasNext()) {
            elementName = reader.nextName();
            switch (elementName) {
                case "AuthFailure":
                    if (reader.nextTag().equals("AuthFailure")) {
                        readAuthFailure(reader);
                    } else {
                        reader.closeElement();
                    }
                    break;
                case "ipAddress":
                    readIpAddress(reader);
                    break;
                case "authTimestamp":
                    readAuthTimestamp(reader);
                    break;
                case "authMethod":
                    readAuthMethod(reader);
                    break;
                default:
                    break;
            }
        }
    }

    private static void readAuthFailure(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            elementName = reader.nextName();
            switch (elementName) {
                case "id":
                    System.out.println("ID: " + reader.nextInt());
                    break;
                case "isFailed":
                    System.out.println("Is Failed: " + reader.nextBoolean());
                    break;
                default:
                    break;
            }
        }
        reader.closeElement();
    }

    private static void readIpAddress(XMLStreamReader reader) throws XMLStreamException {
        System.out.println("IP Address: " + reader.nextString());
    }

    private static void readAuthTimestamp(XMLStreamReader reader) throws XMLStreamException {
        System.out.println("Auth Timestamp: " + reader.nextLong());
    }

    private static void readAuthMethod(XMLStreamReader reader) throws XMLStreamException {
        System.out.println("Auth Method: " + reader.nextString());
    }
}