import java.util.Stack;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class java_40283_XMLParser_A08 {

    private Stack<String> stack = new Stack<>();

    private String fileName;
    private StringBuilder content = new StringBuilder();

    public java_40283_XMLParser_A08(String fileName) {
        this.fileName = fileName;
    }

    public void parse() {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            int c;
            while ((c = fis.read()) != -1) {
                content.append((char) c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringTokenizer st = new StringTokenizer(content.toString());

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("<")) {
                stack.push(token);
            } else if (token.equals(">")) {
                if (stack.peek().equals("<")) {
                    processStartElement();
                }
            }
        }
    }

    private void processStartElement() {
        // Insert your integrity check code here, which is not provided.
    }
}