public class java_02028_XMLParser_A03 {
    private String xmlContent;

    public java_02028_XMLParser_A03(String xmlContent) {
        this.xmlContent = xmlContent;
    }

    public void parse() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            InputSource is = new StringInputSource(xmlContent);
            Document doc = dBuilder.parse(is);

            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String xmlContent = "<note>\n" +
                "  <to>Tove</to>\n" +
                "  <from>Jani</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Don't forget me this weekend!</body>\n" +
                "</note>";
        MinimalistXMLParser parser = new MinimalistXMLParser(xmlContent);
        parser.parse();
    }
}