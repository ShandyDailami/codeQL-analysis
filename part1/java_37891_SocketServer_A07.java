import java.io.*;
import java.net.*;
import java.util.*;

public class java_37891_SocketServer_A07 {

    private static final String AUTH_FILE = "auth.txt";
    private static final int PORT = 5000;
    private static List<String> authorizedUsers = new ArrayList<>();

    static {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(AUTH_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                authorizedUsers.add(line.trim());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new SocketHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class SocketHandler implements Runnable {
        private Socket socket;
        public java_37891_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String clientMessage = in.readLine();
                if (isAuthorized(clientMessage)) {
                    out.writeBytes("Connection successful\n");
                } else {
                    out.writeBytes("Connection failed due to unauthorized user\n");
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private boolean isAuthorized(String clientMessage) {
            return authorizedUsers.contains(clientMessage);
        }
    }
}