import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_15347_FileScanner_A08 {

    private final File directory;
    private final SecurityManager securityManager;

    public java_15347_FileScanner_A08(File directory, SecurityManager securityManager) {
        this.directory = directory;
        this.securityManager = securityManager;
    }

    public void scan(String name) throws IOException {
        securityManager.checkPermission(new Permission.Group("file"));

        File file = new File(directory, name);

        if (file.isFile()) {
            try (FileChannel channel = new FileInputStream(file).getChannel()) {
                channel.position(0);
                byte[] bytes = new byte[(int) channel.size()];
                channel.read(new FileBuffer(bytes, 0, bytes.length));
            }
        }
    }

    private static class FileBuffer extends java.nio.channels.FileChannel$FileLock implements PrivilegedAction<byte[]> {

        private final byte[] bytes;
        private final int offset;
        private final int length;

        public java_15347_FileScanner_A08(byte[] bytes, int offset, int length) {
            this.bytes = bytes;
            this.offset = offset;
            this.length = length;
        }

        @Override
        public byte[] run() {
            if (length > 0) {
                byte[] data = new byte[length];
                if (offset < bytes.length) {
                    System.arraycopy(bytes, offset, data, 0, length);
                }
                return data;
            }
            return new byte[0];
        }
    }
}