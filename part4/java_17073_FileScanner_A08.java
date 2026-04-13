import java.io.*;

public class java_17073_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String integrityFailureFilePath = "/path/to/integrity_failure_file";

        File directory = new File(directoryPath);
        File integrityFailureFile = new File(integrityFailureFilePath);

        try {
            checkDirectoryIntegrity(directory, integrityFailureFile);
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    private static void checkDirectoryIntegrity(File directory, File integrityFailureFile) throws IOException {
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IOException("The provided path does not refer to a valid directory.");
        }

        if (!integrityFailureFile.exists() || integrityFailureFile.isDirectory()) {
            throw new IOException("The provided path does not refer to a valid integrity failure file.");
        }

        File[] files = directory.listFiles();
        if (files == null) {
            throw new IOException("Error occurred while getting list of files from directory.");
        }

        for (File file : files) {
            if (file.isFile()) {
                long integrityCheckSum = calculateIntegrityCheckSum(file);
                if (integrityCheckSum != integrityFailureFile.getBytes().length) {
                    System.out.println("Integrity check failed for file: " + file.getName());
                }
            } else if (file.isDirectory()) {
                checkDirectoryIntegrity(file, integrityFailureFile);
            }
        }
    }

    private static long calculateIntegrityCheckSum(File file) throws IOException {
        long sum = 0;
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            sum += calculateFileChecksum(buffer, length);
        }
        fis.close();
        return sum;
    }

    private static long calculateFileChecksum(byte[] buffer, int length) {
        long checksum = 0;
        for (int i = 0; i < length; i++) {
            checksum += buffer[i];
        }
        return checksum;
    }
}