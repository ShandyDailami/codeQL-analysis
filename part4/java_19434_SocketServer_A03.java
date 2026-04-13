import java.io.*;
import java.net.*;
import java.util.*;

public class java_19434_SocketServer_A03 {
    private static List<String> names = new ArrayList<>();
    private static int nextName = 0;
    private static String nextName() {
        return Names.get(nextName++);
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started.");
        while (true) {
            Socket socket = server.accept();
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String input;
                if ((input = in.readLine()) != null) {
                    if ("hello".equals(input)) {
                        out.println("Hello, how are you?");
                    } else {
                        String name = nextName();
                        names.add(name);
                        out.println("Hello, " + name + "!");
                        out.println("Nice to meet you, " + name + "!");
                    }
                }
            } finally {
                socket.close();
            }
        }
    }
}