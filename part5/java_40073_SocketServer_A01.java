import java.io.*;
import java.net.*;

public class java_40073_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Create new thread for handling client
                new HandleClientThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    // Thread for handling a single client
    private static class HandleClientThread extends Thread {
        private final Socket socket;

        public java_40073_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (InputStream input = socket.getInputStream();
                 OutputStream output = socket.getOutputStream()) {

                int clientInput;
                while ((clientInput = input.read()) != -1) {
                    // Perform a security sensitive operation here.
                    // The specific operation is not provided in the request.

                    // Send the response back to the client
                    output.write(clientInput);
                    output.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}