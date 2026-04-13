import java.io.StringReader;
import java.io.IOException;
import javax.xml.parsers.XMLStreamReader;
import javax.xml.parsers.XMLStreamException;

public class java_23897_XMLParser_A07 {

    public static void main(String[] args) {
        String xml = "<bookstore>"
                + "<book category='fiction'>"
                + "<title>Harry Potter</title>"
                + "<author>J.K. Rowling</author>"
                + "<price>29.99</price>"
                + "</book>"
                + "<book category='programming'>"
                + "<title>Mastering Java</title>"
                + "<author>Kathy Sierra</author>"
                + "<price>39.95</price>"
                + "</book>"
                + "</bookstore>";

        parseXml(xml);
    }

    public static void parseXml(String xml) {
        try {
            XMLStreamReader streamReader = new XMLStreamReader(new StringReader(xml));
            while (streamReader.hasNext()) {
                int type = streamReader.next();
                switch (type) {
                    case XMLStreamReader.START_ELEMENT:
                        String elementName = streamReader.getLocalName();
                        System.out.println("Start of book: " + elementName);
                        break;
                    case XMLStreamReader.CHARACTERS:
                        String text = streamReader.getText();
                        System.out.println("Text: " + text);
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        elementName = streamReader.getLocalName();
                        System.out.println("End of book: " + elementName);
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}