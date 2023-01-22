package conf;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class conf {
    public static ServerSocket serverSocket;
    public static Socket cliSock;
    public static PrintWriter out;
    public static String version = "1.0";
    public static int port = 7777;
    public static boolean isConnected = false;
}
