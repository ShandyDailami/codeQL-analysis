import java.io.*;
import java.net.*;

public class java_27941_SocketServer_A01 {
    private static int port = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            // Start a new thread to handle the client
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_27941_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println("Failed to setup I/O streams");
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Message received");
                }
            } catch (IOException e) {
                System.out.println("Failed to read from client");
            }

            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Failed to close the client connection");
            }
        }
    }
}