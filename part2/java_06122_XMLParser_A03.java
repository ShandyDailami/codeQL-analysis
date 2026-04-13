import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamTokenizer;

public class java_06122_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlData = "<note>"
                + "<to>Tove</to>"
                + "<from>Jani</from>"
                + "<heading>Reminder</heading>"
                + "<body>Don't forget me this weekend!</body>"
                + "</note>";

        parse(xmlData);
    }

    public static void parse(String xmlData) {
        XMLStreamReader reader = null;
        XMLStreamTokenizer tokenizer = null;

        try {
            reader = XMLStreamReader.newReader(xmlData.iterator());
            tokenizer = new XMLStreamTokenizer(reader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
       
        } finally {
            if (tokenizer != null) {
                while (tokenizer.nextToken() != XMLStreamTokenizer.END_DOCUMENT) {
                    switch (tokenizer.getEvent()) {
                        case START_ELEMENT:
                            String elementName = tokenizer.getLocalName();
                            System.out.println("Start of element: " + elementName);
                            break;
                        case CHARACTERS:
                            String elementContent = tokenizer.getText();
                            System.out.println("Content of element: " + elementContent);
                            break;
                        case END_ELEMENT:
                            elementName = tokenizer.getLocalName();
                            System.out.println("End of element: " + elementName);
                            break;
                    }
                }
            }
        }
    }
}