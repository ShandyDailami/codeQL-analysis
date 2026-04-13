import java.io.*;
import java.net.*;

public class java_13389_SocketServer_A07 {

    private static final String AUTHENTICATED_USER = "admin";
    private static final String AUTHENTICATED_PASSWORD = "password";

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started at port 4444");

        while (true) {
            Socket socket = server.accept();

            // create a thread for the client
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_13389_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);

                    String[] parts = clientMessage.split(" ");
                    String user = parts[0];
                    String password = parts[1];

                    if (user.equals(AUTHENTICATED_USER) && password.equals(AUTHENTICATED_PASSWORD)) {
                        writer.writeBytes("Authentication successful\n");
                    } else {
                        writer.writeBytes("Authentication failed\n");
                    }

                    writer.flush();
                }

                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}