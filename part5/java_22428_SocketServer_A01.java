import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_22428_SocketServer_A01 {

    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();

        ServerSocket server = null;
        try {
            server = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                executor.execute(new ClientHandler(socket));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            executor.shutdown();
            server.close();
        }
    }

    private static class ClientHandler implements Runnable {
        Socket socket;

        public java_22428_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMessage, serverMessage;
                while (true) {
                    clientMessage = in.readUTF();
                    serverMessage = "Server: " + clientMessage;

                    out.writeUTF(serverMessage);
                    out.flush();

                    if (clientMessage.equals("exit")) {
                        socket.close();
                        break;
                    }
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}