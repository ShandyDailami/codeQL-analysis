import java.io.*;
import java.util.*;

public class java_39227_XMLParser_A01 {
    public static void main(String[] args) throws Exception {
        File inputFile = new File("input.xml");
        File outputFile = new File("output.xml");

        XMLParser xmlParser = new XMLParser();
        xmlParser.parse(inputFile, outputFile);
    }
}

class XMLParser {
    public void parse(File inputFile, File outputFile) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        PrintWriter writer = new PrintWriter(new FileWriter(outputFile));

        String line;
        while ((line = reader.readLine()) != null) {
            writer.println(line); // Write line to output file

            // Remove comment
            if (line.startsWith("<!--")) {
                int endOfComment = line.indexOf("-->");
                if (endOfComment != -1) {
                    line = line.substring(0, endOfComment).trim();
                }
            }

            writer.println(line); // Write line to output file
       
            // Replace "secure" with "not secure"
            line = line.replace("secure", "not secure");

            writer.println(line); // Write line to output file
        }

        reader.close();
        writer.close();
    }
}