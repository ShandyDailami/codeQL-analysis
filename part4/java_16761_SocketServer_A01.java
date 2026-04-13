import java.io.*;
import java.net.*;

public class java_16761_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started on port 12345");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

            // Create a new thread for handling each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_16761_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                // Read the client's name
                String clientName = reader.readLine();
                System.out.println("Client name: " + clientName);

                // Echo the client's name back to them
                writer.writeBytes(clientName + "\n");
                writer.flush();

                String response;
                while ((response = reader.readLine()) != null) {
                    System.out.println("Received: " + response);
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}