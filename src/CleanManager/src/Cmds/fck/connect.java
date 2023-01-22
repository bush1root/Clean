package Cmds.fck;

import Cmds.Command;
import Utils.Logs;
import conf.conf;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class connect extends Command {
    public connect() {
        super("connect", "Connect command", "connect");
    }

    @Override
    public void run(String[] args) {
        try {
            System.out.println();
            Logs.sendInfo("Starting server...");
            conf.serverSocket = new ServerSocket(conf.port);
            Logs.sendInfo("Waiting for the connection...");
            conf.cliSock = conf.serverSocket.accept();
            Logs.sendSuccess("Connection is established!");
            conf.out = new PrintWriter(conf.cliSock.getOutputStream(), true);
            conf.isConnected = true;
            System.out.println();
        } catch (IOException e) {
            Logs.sendError("Error :c");
        }
    }
}