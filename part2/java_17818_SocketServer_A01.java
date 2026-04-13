import java.io.*;
import java.net.*;
import java.util.*;

public class java_17818_SocketServer_A01 {
    private static final int PORT = 12345;
    private static Set<Socket> clients = Collections.newSet();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress() + " connected");
                clients.add(socket);

                // Start a new thread to handle communication with the client
                new HandleClient(socket).start();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

        serverSocket.close();
    }

    private static class HandleClient extends Thread {
        private Socket socket;

        public java_17818_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);

                    // Send back a message to the client
                    out.writeUTF("Hello, client!");
                    out.flush();
                }

                socket.close();
                clients.remove(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}