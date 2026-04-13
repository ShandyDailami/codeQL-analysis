import java.io.*;
import java.util.Stack;

public class java_28988_XMLParser_A01 {
    private BufferedReader reader;
    private String line;
    private Stack<String> elementStack;

    public java_28988_XMLParser_A01(File file) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(file));
        elementStack = new Stack<>();
    }

    public void parse() throws IOException {
        while ((line = reader.readLine()) != null) {
            parseLine(line);
        }
    }

    private void parseLine(String line) {
        if (line.trim().isEmpty()) {
            // skip empty lines
            return;
        }

        if (line.trim().startsWith("<")) {
            // start of an element
            int start = line.trim().indexOf(' ');
            if (start != -1) {
                String tag = line.trim().substring(1, start);
                elementStack.push(tag);
            } else {
                String tag = line.trim().substring(1);
                elementStack.push(tag);
            }
        } else if (line.trim().startsWith("</")) {
            // end of an element
            String tag = elementStack.pop();
            // process end element
            processEndElement(tag);
        } else if (!elementStack.isEmpty()) {
            // process content of an element
            String tag = elementStack.peek();
            processContent(tag, line.trim());
        }
    }

    private void processEndElement(String tag) {
        // handle end element here
    }

    private void processContent(String tag, String content) {
        // handle content here
    }

    public static void main(String[] args) throws IOException {
        XmlParser parser = new XmlParser(new File("input.xml"));
        parser.parse();
    }
}