import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_36800_XMLParser_A07 {
    public static void parse(XMLStreamReader reader) throws XMLStreamException {
        int event;

        // Start parsing
        while (reader.hasNext()) {
            event = reader.nextEvent();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    event = reader.next();
                    switch (event) {
                        case "book":
                            System.out.println("Found book element");
                            break;
                        case "title":
                            event = reader.next();
                            System.out.println("Found title element: " + event);
                            break;
                        case "author":
                            event = reader.next();
                            System.out.println("Found author element: " + event);
                            break;
                        default:
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    event = reader.next();
                    switch (event) {
                        case "book":
                            System.out.println("Ended book element");
                            break;
                        default:
                            break;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    System.out.println("Found text: " + reader.getText());
                    break;
                default:
                    break;
            }
        }

        // Close parser
        reader.close();
    }

    public static void main(String[] args) {
        String xml = "<library><book><title>Book Title</title><author>Author Name</author></book></library>";

        try {
            XMLStreamReader reader = XMLStreamReader.newInstance(xml.toCharArray());
            parse(reader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}