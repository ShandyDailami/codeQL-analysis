import java.io.*;
import java.net.*;
import java.util.*;

public class java_05228_SocketServer_A07 {
    private static List<Socket> clientSockets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started.");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");
            clientSockets.add(clientSocket);

            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_05228_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);

                    if (request.equals("close")) {
                        clientSocket.close();
                        System.out.println("Client disconnected.");
                        return;
                    }

                    out.writeBytes("Received: " + request + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}