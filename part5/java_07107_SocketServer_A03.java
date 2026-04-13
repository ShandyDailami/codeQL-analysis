import java.io.*;
import java.net.*;
import java.util.*;

public class java_07107_SocketServer_A03 {

    private static List<Socket> clientSockets = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            clientSockets.add(clientSocket);
            System.out.println("New client connected");

            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private DataInputStream input;
        private DataOutputStream output;

        public java_07107_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
            try {
                input = new DataInputStream(clientSocket.getInputStream());
                output = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String message = input.readUTF();
                    System.out.println("Client says: " + message);

                    for (Socket socket : clientSockets) {
                        output.writeUTF(message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
           
                clientSockets.remove(clientSocket);
                clientSocket.close();
            }
        }
    }
}