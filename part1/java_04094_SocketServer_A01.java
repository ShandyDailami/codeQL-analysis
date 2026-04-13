import java.io.*;
import java.net.*;

public class java_04094_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // create a socket for the server
        ServerSocket serverSocket = new ServerSocket(8189);

        System.out.println("Server is listening on port 8189");

        while (true) {
            // accept a new client
            Socket socket = serverSocket.accept();

            // create a new thread for the client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_04094_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // create input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // read the message from the client
                String message = in.readLine();
                System.out.println("Client says: " + message);

                // send a welcome message to the client
                out.println("Welcome to the server!");

                // close the connection
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}