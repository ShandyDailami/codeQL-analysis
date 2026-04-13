public class java_28861_XMLParser_A08 {

    private StringBuilder sb;

    public java_28861_XMLParser_A08() {
        this.sb = new StringBuilder();
    }

    public void write(String str) {
        sb.append(str);
    }

    public String read() {
        return sb.toString();
    }

    public boolean parse(String xml) {
        if (!isWellFormed(xml)) {
            System.out.println("Error: The XML document is not well-formed.");
            return false;
        }

        // Here goes the actual parsing code...

        return true;
    }

    private boolean isWellFormed(String xml) {
        try {
            new javax.xml.parsers.SAXParser().parse(
                new java.io.StringReader(xml), new DummyHandler()
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static class DummyHandler extends javax.xml.parsers.SAXHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                                 javax.xml.parsers.Event evt) throws javax.xml.parsers.SAXException {
            // Intentionally empty. This is a dummy handler.
        }
    }

    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        parser.write("<document>This is a test document.</document>");
        System.out.println("Read: " + parser.read());
        System.out.println("Parsed: " + parser.parse(parser.read()));
    }
}