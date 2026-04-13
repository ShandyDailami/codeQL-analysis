import java.io.*;
import java.net.*;
import java.util.*;

public class java_23479_SocketServer_A03 {
    private static ArrayList<Socket> clientList = new ArrayList<Socket>();
    private static ServerSocket serverSocket;
    private static int port;

    public static void main(String[] args) {
        try {
            port = Integer.parseInt(args[0]);
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                clientList.add(socket);

                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error in accepting client: " + e.getMessage());
       
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.out.println("Error while closing the server socket: " + e.getMessage());
                }
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private DataInputStream dis;
        private DataOutputStream dos;

        public java_23479_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                System.out.println("Error in creating input/output streams: " + e.getMessage());
            }
        }

        public void run() {
            String message;
            while (true) {
                try {
                    message = dis.readUTF();
                    System.out.println("Received: " + message);

                    // For testing injection
                    // String injection = dis.readUTF() + dis.readUTF();
                    // System.out.println("Injected: " + injection);
                    // dos.writeUTF(injection);

                    // Echo the message back to the client
                    dos.writeUTF(message);
                } catch (IOException e) {
                    System.out.println("Error in reading/writing: " + e.getMessage());
                    removeClient(socket);
                    break;
                }
            }
        }

        private void removeClient(Socket socket) {
            clientList.remove(socket);
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Error while closing the client socket: " + e.getMessage());
            }
        }
    }
}