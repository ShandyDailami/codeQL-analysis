import java.io.*;
import java.net.*;
import java.util.*;

public class java_11837_SocketServer_A08 {

    private static final String PORT_NUMBER = "1234"; // Use a non-common port number
    private static final int MAX_CONNECTIONS = 5;

    private static List<Socket> clientSockets = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(Integer.parseInt(PORT_NUMBER));
            System.out.println("Server is running on port " + PORT_NUMBER);
            while (true) {
                Socket socket = serverSocket.accept();
                clientSockets.add(socket);
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                new ClientThread(socket).start();
                if (clientSockets.size() > MAX_CONNECTIONS) {
                    // Close the client socket if it's over the max connections
                    socket.close();
                    System.out.println("Closed connection to " + socket.getRemoteSocketAddress());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ClientThread extends Thread {
        private Socket socket;

        public java_11837_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Assume for the purpose of this example that any message received is "Good"
                    if (message.equals("Bad")) {
                        // If the received message is "Bad", simulate an integrity failure by sending a message back to the client
                        out.println("Integrity failure, message was not received");
                    } else {
                        out.println("OK: " + message);
                    }
                }
                socket.close();
                System.out.println("Connection to " + socket.getRemoteSocketAddress() + " closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}