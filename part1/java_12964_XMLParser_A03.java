import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class java_12964_XMLParser_A03 {

    private static final String XML_FILE = "src/main/resources/sample.xml";

    public static void main(String[] args) {

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try (InputStream inputStream = new FileInputStream(new File(XML_FILE));
             XMLEventReader eventReader = xmlInputFactory.createXMLEventReader(inputStream)) {

            List<String> elements = new LinkedList<>();
            String elementValue = null;

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    QName elementName = startElement.getName();
                    elements.add(elementName.getLocalPart());
                } else if (event.isCharacters()) {
                    elementValue = event.asCharacters().getData();
                } else if (event.isEndElement()) {
                    System.out.println("End element: " + event.asEndElement().getName().getLocalPart() + " Value: " + elementValue);
                }
            }

            Iterator<String> iterator = elements.iterator();
            while (iterator.hasNext()) {
                String elementName = iterator.next();
                System.out.println("Element: " + elementName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}