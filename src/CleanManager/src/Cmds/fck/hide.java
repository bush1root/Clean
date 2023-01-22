package Cmds.fck;

import Cmds.Command;
import Utils.Logs;
import conf.conf;

import java.io.IOException;

public class hide extends Command {
    public hide() {
        super("hide", "Hide [Panic]", "hide");
    }

    @Override
    public void run(String[] args) {
        try {
            conf.out.println("0.3");
            conf.out.println("0.3");
            conf.out.flush();
            conf.cliSock.close();
            conf.out.close();
            conf.isConnected = false;
            Logs.sendSuccess("Connection closed. Goodbye!");
            System.exit(-1);
        } catch (IOException ignored) {}
    }
}