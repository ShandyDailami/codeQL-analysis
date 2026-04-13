public class java_29547_XMLParser_A01 {

    public static void parse(String xml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xml)));

            System.out.println("Document parsing successful!");

            // Security-sensitive operations here, such as accessing private data

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String xml = "<root><element>Content</element></root>";
        parse(xml);
    }
}