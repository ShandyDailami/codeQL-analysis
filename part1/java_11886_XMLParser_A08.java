import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_11886_XMLParser_A08 {
    public static void main(String[] args) {
        String xml = "<data><operation>A08_IntegrityFailure</operation><status>Success</status></data>";

        parseXML(xml);
    }

    private static void parseXML(String xml) {
        try (XMLStreamReader reader = XMLStreamReader.newInstance(xml.getBytes())) {
            String prevElement = null;
            String prevNamespace = null;

            while (reader.hasNext()) {
                int type = reader.nextInt();
                switch (type) {
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("Start of document");
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        String element = reader.getLocalName();
                        String namespace = reader.getNamespaceURI();

                        if (prevElement != null && prevNamespace != null) {
                            if (element.equals("operation") && namespace.equals("http://example.com/data")) {
                                System.out.println("Security-sensitive operation detected: A08_IntegrityFailure");
                            }
                        }

                        prevElement = element;
                        prevNamespace = namespace;

                        System.out.println("Start of " + element + " in " + namespace);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("End of " + prevElement + " in " + prevNamespace);
                        break;
                    case XMLStreamConstants.CHARS:
                        System.out.println("Characters: " + reader.getText());
                        break;
                    default:
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}