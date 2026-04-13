import java.io.*;
import java.net.*;
import java.util.*;

public class java_22087_SocketServer_A08 {

    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");

            clients.add(socket);

            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        Socket socket;

        public java_22087_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Here we handle the integrity failure (A08_IntegrityFailure)
                    if (message.equals("fail")) {
                        writer.println("Integrity failure occurred.");
                    } else {
                        writer.println("Handling the message: " + message);
                    }
                }

                clients.remove(socket);
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}