import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40689_SocketServer_A03 {

    public static void main(String[] args) {
        int port = 12345; // any available port
        try {
            ServerSocket server = new ServerSocket(port); // create a server socket
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket socket = server.accept(); // wait for client connection
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // start a new thread for handling the client
                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_40689_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                OutputStream out = socket.getOutputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String input;
                while ((input = in.readLine()) != null) {
                    if (isMaliciousInput(input)) {
                        System.out.println("Malicious input detected: " + input);
                        out.write("Detected malicious input: " + input + "\n".getBytes());
                    } else {
                        System.out.println("Non-malicious input: " + input);
                        out.write(("Received: " + input + "\n").getBytes());
                    }
                }

                socket.close();
            } catch (Exception e) {
                System.out.println("Exception caught: " + e);
            }
        }

        private boolean isMaliciousInput(String input) {
            // here you can implement your security logic for detecting injection attacks
            // e.g., use a whitelist of valid inputs, or a regular expression to detect certain patterns
            // be creative and realistic with your input detection logic
            return false;
        }
    }
}