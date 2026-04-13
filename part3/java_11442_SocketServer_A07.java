import java.io.*;
import java.net.*;
import java.util.*;

public class java_11442_SocketServer_A07 {

    private static final int PORT = 5000;
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                clients.add(socket);
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                Thread clientHandler = new Thread(new ClientHandler(socket));
                clientHandler.start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while trying to bind to port " + PORT);
            System.exit(-1);
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_11442_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    if (message.equals("A07_AuthFailure")) {
                        // Authentication failure, send response
                        out.writeBytes("AuthFailure\n");
                    } else {
                        // Send a response back to the client
                        out.writeBytes("Success\n");
                    }

                    out.flush();
                }

                socket.close();
                clients.remove(socket);
            } catch (IOException e) {
                System.out.println("Error occurred while handling client " + socket.getRemoteSocketAddress());
            }
        }
    }
}