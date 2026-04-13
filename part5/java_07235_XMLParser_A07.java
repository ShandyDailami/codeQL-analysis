import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class java_07235_XMLParser_A07 {
    public static void main(String[] args) {
        List<Person> persons = parseXmlFile("people.xml");

        for (Person person : persons) {
            System.out.println(person);
        }
    }

    public static List<Person> parseXmlFile(String xmlFilePath) {
        DefaultHandler handler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equals("Person")) {
                    persons.add(new Person());
                    persons.get(persons.size() - 1).setName(attributes.getValue("Name"));
                    persons.get(persons.size() - 1).setAge(attributes.getValue("Age"));
                }
            }
        };

        File xmlFile = new File(xmlFilePath);
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXParseException e) {
            System.out.println("Parsing error at line " + e.getLineNumber() + ": " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + xmlFilePath);
        } catch (ParserConfigurationException e) {
            System.out.println("Error creating XMLReader: " + e.getMessage());
        }

        return persons;
    }
}