import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13050_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444); // listen on port 4444
            while (true) { // forever loop
                Socket socket = server.accept(); // wait for client to connect
                new ClientHandler(socket).start(); // start a new handler thread
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Handles communication with a client
    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_13050_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Message received");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}