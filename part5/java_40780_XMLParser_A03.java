import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLTokener;
import javax.xml.stream.XMLStreamConstants;

public class java_40780_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlContent = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        XMLTokener tokener = new XMLTokener(xmlContent);
        XMLStreamReader streamReader = new XMLStreamReader(tokener);

        try {
            while(streamReader.hasNext()) {
                int event = streamReader.next();

                switch(event) {
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("Start element: " + streamReader.getLocalName());
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        System.out.print("Character data: " + streamReader.getText());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("End element: " + streamReader.getLocalName());
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}