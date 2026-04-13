import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class java_41410_XMLParser_A03 {

    public void parse(XMLStreamReader reader) throws XMLStreamException {
        int event;
        String elementName;
        while (reader.hasNext()) {
            event = reader.nextEvent();
            switch (event) {
                case XMLEvent.START_ELEMENT:
                    elementName = reader.getLocalName();
                    if (elementName.equals("element1")) {
                        System.out.println("Found element1");
                    } else if (elementName.equals("element2")) {
                        System.out.println("Found element2");
                    }
                    break;
                case XMLEvent.END_ELEMENT:
                    elementName = reader.getLocalName();
                    if (elementName.equals("element1")) {
                        System.out.println("End of element1");
                    } else if (elementName.equals("element2")) {
                        System.out.println("End of element2");
                    }
                    break;
            }
        }
    }
}