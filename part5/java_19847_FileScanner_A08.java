import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19847_FileScanner_A08 {
    private static final String INPUT_DIRECTORY = "input";
    private static final String OUTPUT_DIRECTORY = "output";

    public static void main(String[] args) throws FileNotFoundException {
        File inputDirectory = new File(INPUT_DIRECTORY);
        File outputDirectory = new File(OUTPUT_DIRECTORY);

        if (!inputDirectory.exists() || !outputDirectory.exists()) {
            throw new RuntimeException("Input or output directory does not exist.");
        }

        File[] inputFiles = inputDirectory.listFiles();

        if (inputFiles == null) {
            throw new RuntimeException("No files found in input directory.");
        }

        for (File inputFile : inputFiles) {
            if (!inputFile.isFile()) {
                throw new RuntimeException("Input directory contains a non-file: " + inputFile);
            }

            if (!inputFile.canRead()) {
                throw new RuntimeException("Input file cannot be read: " + inputFile);
            }

            String fileContent = readFileContent(inputFile);
            String hashedContent = hashFileContent(fileContent);

            if (hashedContent.equals("FAILURE")) {
                throw new RuntimeException("Integrity failure detected in file: " + inputFile);
            }

            String outputFilePath = outputDirectory.getAbsolutePath() + "/" + inputFile.getName();
            File outputFile = new File(outputFilePath);

            if (outputFile.exists()) {
                throw new RuntimeException("Output file already exists: " + outputFile);
            }

            writeFileContent(outputFile, hashedContent);
        }
    }

    private static String readFileContent(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StringBuilder content = new StringBuilder();
        while (scanner.hasNextLine()) {
            content.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        return content.toString();
    }

    private static String hashFileContent(String content) {
        // Implement your hash function here.
        // For example, you can use the SHA256 algorithm.
        // You can use libraries like org.apache.commons.codec.digest.DigestUtils
        // For simplicity, this example just returns the hashed content itself.
        return content;
    }

    private static void writeFileContent(File file, String content) throws FileNotFoundException {
        try (java.io.PrintWriter writer = new java.io.PrintWriter(file)) {
            writer.print(content);
        }
    }
}