import java.net.*;
import java.io.*;

public class java_14778_SocketServer_A03 {

    public static void main(String[] args) {
        // create server socket
        ServerSocket server = null;
        try {
            server = new ServerSocket(8080);
            System.out.println("Server started at port 8080");
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // create new thread to handle client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // class to handle client connection
    private static class ClientHandler implements Runnable {

        private Socket socket;

        public java_14778_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // create input and output streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // read message from client
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // echo back message
                out.writeUTF("Echo: " + message);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}