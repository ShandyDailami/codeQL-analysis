import java.io.*;
import java.net.*;
import java.util.*;

public class java_18080_SocketServer_A07 {

    private static final int PORT = 4445;
    private static Set<Socket> clients = Collections.synchronizedSet(new HashSet<Socket>());

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                clients.add(socket);

                HandleClient hc = new HandleClient(socket);
                Thread t = new Thread(hc);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class HandleClient implements Runnable {

        private Socket socket;

        public java_18080_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Client: " + clientMessage);

                    // Send the message to all clients except the sender
                    for (Socket s : clients) {
                        if (s != socket) {
                            s.getOutputStream().write((clientMessage + "\n").getBytes());
                        }
                    }
                }

                socket.close();
                clients.remove(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}