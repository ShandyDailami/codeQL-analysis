import java.io.*;
import java.net.*;
import java.util.*;

public class java_28579_SocketServer_A08 {
    private static ArrayList<Socket> clientList = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(8080);
            System.out.println("Server started on port 8080");
            while(true) {
                Socket client = server.accept();
                clientList.add(client);
                System.out.println("Client connected from: " + client.getRemoteSocketAddress());

                Thread thread = new Thread(new ClientHandler(client));
                thread.start();
            }
        } catch(IOException ex) {
            System.out.println("Error in server: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException ex) {
                System.out.println("Error in closing server: " + ex.getMessage());
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public java_28579_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch(IOException ex) {
                System.out.println("Error getting input or output streams: " + ex.getMessage());
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    for(Socket sock : clientList) {
                        if(sock != clientSocket) {
                            out = new PrintWriter(sock.getOutputStream(), true);
                            out.println(message);
                        }
                    }
                }
            } catch(IOException ex) {
                System.out.println("Error in client communication: " + ex.getMessage());
            }
            closeConnection();
        }

        private void closeConnection() {
            try {
                clientSocket.close();
                in.close();
                out.close();
            } catch(IOException ex) {
                System.out.println("Error in closing connection: " + ex.getMessage());
            }
        }
    }
}