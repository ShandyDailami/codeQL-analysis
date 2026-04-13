import java.io.*;

public class java_37048_FileScanner_A08 {

    private static final String INPUT_DIR = "/path/to/input/directory";
    private static final String OUTPUT_DIR = "/path/to/output/directory";

    public static void main(String[] args) throws IOException {
        FileScanner scanner = new FileScanner();
        File[] inputFiles = scanner.getFileList(INPUT_DIR);

        for (File inputFile : inputFiles) {
            File outputFile = new File(OUTPUT_DIR, inputFile.getName());
            scanner.checkIntegrity(inputFile, outputFile);
        }
    }

    private static class FileScanner {

        private File[] getFileList(String path) {
            File folder = new File(path);
            return folder.listFiles();
        }

        private void checkIntegrity(File inputFile, File outputFile) throws IOException {
            if (outputFile.exists()) {
                throw new SecurityException("Output file already exists, please use a different name.");
            }

            if (!inputFile.exists()) {
                throw new FileNotFoundException("Input file does not exist.");
            }

            if (!inputFile.canRead()) {
                throw new SecurityException("Input file is not readable.");
            }

            long inputFileLength = inputFile.length();
            long outputFileLength = outputFile.length();

            if (inputFileLength != outputFileLength) {
                throw new SecurityException("Integrity failure detected. Input file length is not equal to output file length.");
            }

            try (InputStream in = new FileInputStream(inputFile); OutputStream out = new FileOutputStream(outputFile)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            }
        }
    }
}