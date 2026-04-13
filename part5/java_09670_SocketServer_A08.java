import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class java_09670_SocketServer_A08 {
    private static ArrayList<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(8080);
            System.out.println("Server is running...");
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected...");
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                clients.add(out);
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_09670_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    for (PrintWriter out : clients) {
                        out.println(inputLine);
                    }
                }
            } catch (IOException ex) {
                clients.remove(clientSocket);
                System.out.println("Client disconnected.");
            }
        }
    }
}