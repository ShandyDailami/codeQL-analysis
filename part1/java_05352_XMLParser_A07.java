public class java_05352_XMLParser_A07 {

    private static class AuthFailureHandler implements org.xml.sax.helpers.DefaultHandler {

        private int errorCount = 0;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // This handler will not be called for security-sensitive operations.
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // This handler will not be called for security-sensitive operations.
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // This handler will not be called for security-sensitive operations.
        }

        @Override
        public void ignorableWhitespace(char[] chars, int start, int length) throws SAXException {
            // This handler will not be called for security-sensitive operations.
        }

        @Override
        public void fatalError(SAXException e) throws SAXException {
            errorCount++;
            System.out.println("A fatal error has occurred. Error count: " + errorCount);
            e.printStackTrace(System.out);
        }

        @Override
        public void warning(SAXParseException e) throws SAXException {
            System.out.println("A warning has occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        // Load the XML file
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(Main.class.getResourceAsStream("/sample.xml"));

        // Set the error handler
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        saxFactory.setNamespaceAware(false);
        SAXParser saxParser = saxFactory.newSAXParser(new Properties());
        saxParser.setProperty(XMLConstants.ACCESS_CONTROL_PROPERTY, "no-access-to-all");
        saxParser.setProperty(XMLConstants.ACCESS_CONTROL_EXTERNAL_PROPERTY, "no-access-external");
        saxParser.setProperty(XMLConstants.ACCESS_CONTROL_SCRIPT_EXTERNAL_PROPERTY, "no-access-script-external");
        saxParser.setProperty(XMLConstants.ACCESS_CONTROL_STYLESHEET_EXTERNAL_PROPERTY, "no-access-stylesheet-external");
        saxParser.setProperty(XMLConstants.ACCESS_CONTROL_OBJECT_EXTERNAL_PROPERTY, "no-access-object-external");
        saxParser.setProperty(XMLConstants.ACCESS_CONTROL_LINK_EXTERNAL_PROPERTY, "no-access-link-external");
        saxParser.setProperty(XMLConstants.ACCESS_CONTROL_STYLE_EXTERNAL_PROPERTY, "no-access-style-external");
        AuthFailureHandler errorHandler = new AuthFailureHandler();
        saxParser.setErrorHandler(errorHandler);

        // Process the XML
        saxParser.parse(new InputSource(new StringReader(doc.getDocumentElement().getOuterXml())), errorHandler);
    }
}