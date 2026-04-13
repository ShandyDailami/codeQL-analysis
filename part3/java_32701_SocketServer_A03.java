import java.io.*;
import java.net.*;
import java.util.*;

public class java_32701_SocketServer_A03 {
    private static List<Socket> clients = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        while (true) {
            Socket socket = server.accept();
            clients.add(socket);
            Thread thread = new Thread(new ServerThread(socket));
            thread.start();
        }
    }

    private static class ServerThread implements Runnable {
        private Socket socket;

        public java_32701_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request;
                while ((request = in.readLine()) != null) {
                    // A03_Injection: This is a clear example of a injection point.
                    String user = request.substring(request.indexOf('=') + 1);
                    // More operations

                    for (Socket client : clients) {
                        if (client != socket && client.isConnected()) {
                            DataOutputStream outToClient = new DataOutputStream(client.getOutputStream());
                            outToClient.writeBytes("Hello, " + user + "\n");
                            outToClient.flush();
                        }
                    }
                }
            } catch (IOException e) {
                clients.remove(socket);
                socket.close();
            }
        }
    }
}