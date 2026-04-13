import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_06564_SocketServer_A01 {
    private static final String BIND_ADDRESS = "localhost";
    private static final int PORT = 8080;
    private static final byte[] PASSWORD = "password".getBytes();

    private static Set<Socket> clients = new HashSet<>();

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on " + BIND_ADDRESS + ":" + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client " + client.getRemoteSocketAddress() + " connected");

                clients.add(client);

                new SecureSocketHandler(client).start();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private static class SecureSocketHandler extends Thread {
        private final Socket socket;
        private final DataInputStream in;
        private final DataOutputStream out;

        public java_06564_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException ex) {
                System.err.println(ex);
                return;
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readUTF()) != null) {
                    System.out.println("Received: " + message);

                    for (Socket client : clients) {
                        if (client != socket) {
                            out.writeUTF(message);
                            out.flush();
                        }
                    }
                }
            } catch (IOException ex) {
                System.err.println(ex);
            }

            clients.remove(socket);
            socket.close();
        }
    }
}