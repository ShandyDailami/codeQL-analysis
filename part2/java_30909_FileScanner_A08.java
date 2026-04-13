import java.io.*;

public class java_30909_FileScanner_A08 {

    private static final String INTEGRITY_FAILURE_PATTERN = "%s integrity failure at line %d in file %s";
    private static final String WRITE_ERROR_MESSAGE = "Error while writing to file";

    private java_30909_FileScanner_A08() {}

    public static void checkFilesIntegrity(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files == null) return;

        for (File file : files) {
            try {
                checkFileIntegrity(file);
            } catch (IOException e) {
                System.out.println(String.format(WRITE_ERROR_MESSAGE, file.getName(), e));
            }
        }
    }

    private static void checkFileIntegrity(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        int prevChecksum = fis.getChannel().hashCode();

        int bufferSize = 4096;
        byte[] buffer = new byte[bufferSize];
        int bytesRead;

        while ((bytesRead = fis.read(buffer)) != -1) {
            int currentChecksum = fis.getChannel().hashCode();

            if (currentChecksum != prevChecksum) {
                throw new IntegrityFailureException(
                        String.format(INTEGRITY_FAILURE_PATTERN, file.getName(), fis.getChannel().getPos(), file.getPath()));
            }

            prevChecksum = currentChecksum;
        }

        fis.close();
    }

    public static class IntegrityFailureException extends RuntimeException {
        public java_30909_FileScanner_A08(String message) {
            super(message);
        }
    }
}