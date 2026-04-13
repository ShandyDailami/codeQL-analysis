import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_35168_SocketServer_A03 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is running and waiting for clients...");

        executor = Executors.newCachedThreadPool();

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");
            Handler handler = new Handler(socket);
            executor.execute(handler);
        }
    }

    static class Handler implements Runnable {

        private Socket socket;

        public java_35168_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                DataInputStream dis = new DataInputStream(input);
                String query = dis.readUTF();

                if (isBadQuery(query)) {
                    sendBadQueryResponse(socket);
                } else {
                    sendGoodQueryResponse(socket, query);
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void sendBadQueryResponse(Socket socket) {
            try {
                OutputStream output = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(output);
                dos.writeUTF("Error: SQL Injection detected. Please provide a valid query.");
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void sendGoodQueryResponse(Socket socket, String query) {
            try {
                OutputStream output = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(output);
                dos.writeUTF("Good query: " + query);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean isBadQuery(String query) {
            return query.contains("DROP");
        }
    }
}