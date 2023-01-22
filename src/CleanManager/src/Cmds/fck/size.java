package Cmds.fck;

import Cmds.Command;
import Utils.Logs;
import conf.conf;

public class size extends Command {
    public size() {
        super("size", "Change hitbox size", "size <value>");
    }

    @Override
    public void run(String[] args) {
        try {
            if (conf.isConnected) {
                conf.out.println(Double.parseDouble(args[1]));
                conf.out.println(Double.parseDouble(args[1]));
                Logs.sendSuccess("Done, hits size changed to: " + args[1]);
            } else {
                Logs.sendError("Connection not found");
            }
        } catch (Exception e) {
            Logs.sendError("Error :c");
        }
    }
}