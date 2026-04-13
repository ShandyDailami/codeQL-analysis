public class java_09812_XMLParser_A03 {
    private String xmlContent;

    public java_09812_XMLParser_A03(String xmlContent) {
        this.xmlContent = xmlContent;
    }

    public void parse() {
        System.out.println("Parsing XML content...");

        // Simplified parsing logic, no validation or error handling
        String[] lines = xmlContent.split("\\r?\\n");
        for (String line : lines) {
            if (line.trim().startsWith("<")) {
                System.out.println("Start tag: " + line);
            } else if (line.trim().startsWith("</")) {
                System.out.println("End tag: " + line);
            } else {
                System.out.println("Data: " + line);
            }
        }

        System.out.println("XML content parsed successfully.");
    }
}

public class Main {
    public static void main(String[] args) {
        String xmlContent = "<xml>\n" +
                "    <element1>Value 1</element1>\n" +
                "    <element2>Value 2</element2>\n" +
                "</xml>";

        XmlParser xmlParser = new XmlParser(xmlContent);
        xmlParser.parse();
    }
}