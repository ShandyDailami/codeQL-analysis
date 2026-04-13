import java.io.*;
import java.net.*;
import java.util.*;

public class java_25834_SocketServer_A03 {

    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3333);
        System.out.println("Server started on port 3333");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            clients.add(socket);

            Thread clientThread = new Thread(new ClientHandler(socket));
            clientThread.start();
        }
    }

    static class ClientHandler implements Runnable {

        private Socket socket;

        public java_25834_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);
                    // Perform security sensitive operation related to A03_Injection, here we just print back the message
                    System.out.println("Sending: " + clientMessage);
                    writer.println(clientMessage);
                }

                socket.close();
                clients.remove(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}