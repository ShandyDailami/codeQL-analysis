import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamToken;

public class java_21236_XMLParser_A01 {
    public void parse(String xml) {
        try {
            XMLStreamReader reader = XMLStreamUtilities.createXMLStreamReader(xml);

            int event;
            while ((event = reader.next()) != XMLStreamToken.END_DOCUMENT) {
                switch (event) {
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("Start of document");
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = reader.getLocalName();
                        System.out.println("Start of element: " + elementName);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String charData = reader.getText();
                        System.out.println("Characters: " + charData);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = reader.getLocalName();
                        System.out.println("End of element: " + elementName);
                        break;
                    case XMLStreamConstants.COMMENT:
                        String comment = reader.getComment();
                        System.out.println("Comment: " + comment);
                        break;
                    case XMLStreamConstants.DOCUMENT_TYPE:
                        String doctype = reader.getDoctypeDecl().getName();
                        System.out.println("Document type: " + doctype);
                        break;
                    default:
                        break;
                }
            }

            System.out.println("End of document");
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String xml = "<note>\n" +
                "    <to>Tove</to>\n" +
                "    <from>Jani</from>\n" +
                "    <heading>Reminder</heading>\n" +
                "    <body>Don't forget me this weekend!</body>\n" +
                "  </note>";
        new MyXMLParser().parse(xml);
    }
}