import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.SocketException;

public class java_37724_SocketServer_A01 {
    private static final String LOCAL_HOST = "127.0.0.1";
    private static final int PORT = 1234;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            // Create Server Socket
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(LOCAL_HOST, PORT));

            System.out.println("Server is listening on " + LOCAL_HOST + " on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected.");

                // Only accept connections from specific IP
                InetAddress clientAddress = socket.getInetAddress();
                if (!clientAddress.getHostAddress().equals("127.0.0.1")) {
                    System.out.println("Client " + socket.getRemoteSocketAddress() + " is not local. Accepting only from localhost.");
                    continue;
                }

                // Start a new thread to handle the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_37724_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Get input and output streams
                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();

                // Read request
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String request = reader.readLine();
                System.out.println("Received: " + request);

                // Write response
                String response = "Server response: " + request;
                output.write(response.getBytes());
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}