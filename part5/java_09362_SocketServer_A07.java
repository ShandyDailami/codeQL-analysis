import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09362_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(4444)) {
            System.out.println("Server is listening on port 4444");

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("A client has connected");

                AuthenticationThread authThread = new AuthenticationThread(clientSocket);
                authThread.start();
            }
        } catch (IOException ex) {
            System.out.println("Error with client connection");
            ex.printStackTrace();
        }
    }

    static class AuthenticationThread extends Thread {
        private final Socket socket;

        public java_09362_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                AuthenticationProtocol protocol = new AuthenticationProtocol(socket);
                String username = protocol.readUsername();
                String password = protocol.readPassword();

                if (isValid(username, password)) {
                    protocol.writeSuccess();
                } else {
                    protocol.writeFailure();
                }

                socket.close();
            } catch (IOException ex) {
                System.out.println("Error handling client connection");
                ex.printStackTrace();
            }
        }

        private boolean isValid(String username, String password) {
            return USERNAME.equals(username) && PASSWORD.equals(password);
        }
    }

    static class AuthenticationProtocol {
        private final Socket socket;

        public java_09362_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public String readUsername() throws IOException {
            // read username from the socket
            // for simplicity, we just return a hardcoded username
            return "user";
        }

        public String readPassword() throws IOException {
            // read password from the socket
            // for simplicity, we just return a hardcoded password
            return "password";
        }

        public void writeSuccess() throws IOException {
            // write success response to the socket
            socket.getOutputStream().write("Success".getBytes());
        }

        public void writeFailure() throws IOException {
            // write failure response to the socket
            socket.getOutputStream().write("Failure".getBytes());
        }
    }
}