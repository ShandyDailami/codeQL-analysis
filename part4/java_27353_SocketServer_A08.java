import java.io.*;
import java.net.*;
import java.util.*;

public class java_27353_SocketServer_A08 {
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6000);
            System.out.println("Server is listening on port 6000...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clients.add(clientSocket);
                System.out.println("New client connected!");

                Thread clientHandler = new Thread(new ClientHandler(clientSocket));
                clientHandler.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        Socket clientSocket;

        public java_27353_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Handling A08_IntegrityFailure
                    if (message.equalsIgnoreCase("fail")) {
                        out.writeBytes("A08_IntegrityFailure\n");
                        out.flush();
                        clientSocket.close();
                        clients.remove(clientSocket);
                        System.out.println("Client disconnected!");
                    } else {
                        out.writeBytes(message + "\n");
                        out.flush();
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}