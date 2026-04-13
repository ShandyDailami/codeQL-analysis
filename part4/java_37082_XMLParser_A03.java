public class java_37082_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        // Parse the document
        Document doc = dBuilder.parse(new InputSource(new StringReader("<person>John Doe</person>")));
        doc.getDocumentElement().normalize();

        // Prints: <person>John Doe</person>
        System.out.println(doc.getElementsByTagName("person").item(0).getTextContent());
    }
}