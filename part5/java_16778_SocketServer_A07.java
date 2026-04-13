import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class java_16778_SocketServer_A07 {
    private static final String PASSWORD_HASH = "$2a$10$"; // This is a hash, not a password. This is a placeholder.
    private static Map<String, String> usernamePasswordMap = new HashMap<>();

    static {
        usernamePasswordMap.put("user1", "password1");
        usernamePasswordMap.put("user2", "password2");
        usernamePasswordMap.put("user3", "password3");
    }

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            new Handler(socket).start();
        }
    }

    private static class Handler extends Thread {
        private final Socket socket;
        private final InputStream inputStream;
        private final OutputStream outputStream;

        public java_16778_SocketServer_A07(Socket socket) {
            this.socket = socket;
            this.inputStream = null;
            this.outputStream = null;

            try {
                this.inputStream = socket.getInputStream();
                this.outputStream = socket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                readUsername();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void readUsername() throws IOException {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            String username = dataInputStream.readUTF();
            String password = dataInputStream.readUTF();

            if (authenticate(username, password)) {
                dataOutputStreamSuccess();
            } else {
                dataOutputStreamFailure();
            }

            socket.close();
        }

        private void dataOutputStreamSuccess() {
            try {
                dataOutputStream("Authentication successful!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void dataOutputStreamFailure() {
            try {
                dataOutputStream("Authentication failed!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void dataOutputStream(String message) throws IOException {
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
        }

        private boolean authenticate(String username, String password) {
            return PASSWORD_HASH.equals(usernamePasswordMap.get(username));
        }
    }
}