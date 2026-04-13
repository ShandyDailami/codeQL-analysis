public class java_24291_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            XMLParser parser = new XMLParser();
            parser.parse("src/main/resources/sample.xml");
        } catch (Exception e) {
            System.out.println("An error occurred while parsing the XML file: " + e.getMessage());
        }
    }
}

class XMLParser {
    public void parse(String filepath) throws Exception {
        // Load the XML file
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File(filepath));

        // Normalize the XML file
        Cleaner cleaner = Cleaner.getInstance();
        DocumentCleaner dCleaner = cleaner.withoutChoosingWriter(true);
        doc = dCleaner.clean(doc);

        // Print the XML file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);
    }
}