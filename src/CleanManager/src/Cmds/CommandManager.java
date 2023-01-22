package Cmds;

import Cmds.fck.*;
import Utils.Logs;

import java.util.ArrayList;

public class CommandManager {
    public static ArrayList<Command> commands = new ArrayList<>();

    public void setup() {
        commands.add(new help());
        commands.add(new connect());
        commands.add(new hide());
        commands.add(new size());
        commands.add(new download());
    }

    public void onCommand(String cmd) {
        boolean f = false;

        for (Command c : commands) {
            if (cmd.startsWith(c.name)) {
                f = true;
                if (cmd.split(" ").length >= c.alias.split(" ").length) {
                    c.run(cmd.split(" "));
                } else {
                    Logs.sendError("Use: " + c.alias);
                }
            }
        }

        if (!f) {
            Logs.sendInfo("Type 'help' to get information about the commands");
        }
    }
}