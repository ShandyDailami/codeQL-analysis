public class java_06595_XMLParser_A01 {
    private String xmlString;

    public java_06595_XMLParser_A01(String xmlString) {
        this.xmlString = xmlString;
    }

    public void parse() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xmlString));
            Document doc = dBuilder.parse(is);

            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getElementsByTagName("note").item(0).getTextContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}