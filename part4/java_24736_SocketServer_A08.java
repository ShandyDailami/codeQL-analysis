import java.io.*;
import java.net.*;
import javax.crypto.*;

public class java_24736_SocketServer_A08 {

    // Incoming connection listener
    private static class ConnectionHandler extends Thread {
        private Socket socket;

        public java_24736_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    // Avoiding the use of insecure methods
                    clientMessage = checkIntegrity(clientMessage);
                    out.println("Server received: " + clientMessage);
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String checkIntegrity(String message) {
            // Simulating an integrity failure by reversing the string
            return new StringBuilder(message).reverse().toString();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();
            ConnectionHandler handler = new ConnectionHandler(socket);
            handler.start();
        }
    }
}