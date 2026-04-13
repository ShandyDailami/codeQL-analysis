public class java_24018_XMLParser_A08 {

    public static void main(String[] args) {
        // The XML file to parse
        String xmlFile = "src/main/resources/example.xml";

        // Create the parser
        XMLParser parser = new XMLParser(xmlFile);

        // Parse the XML file
        parser.parse();

        // Print the parsed content
        System.out.println("Parsed content: " + parser.getParsedContent());
    }
}

class XMLParser {
    private String xmlFile;
    private StringBuilder parsedContent;

    public java_24018_XMLParser_A08(String xmlFile) {
        this.xmlFile = xmlFile;
        this.parsedContent = new StringBuilder();
    }

    public void parse() {
        // This is a simplistic implementation, real-world XML parsing
        // would use a library like JAXP or StAX
        // But for the sake of this example, I'll just use a simple StringBuilder

        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(xmlFile));
            while ((line = br.readLine()) != null) {
                parsedContent.append(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getParsedContent() {
        return parsedContent.toString();
    }
}