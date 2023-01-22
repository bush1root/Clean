package Cmds.fck;

import Cmds.Command;
import Cmds.CommandManager;

public class help extends Command {
    public help() {
        super("help", "Help command", "help");
    }

    @Override
    public void run(String[] args) {
        System.out.println("\n Command   - Description");
        for (Command cmd : CommandManager.commands) {
            System.out.print("\n " + cmd.name);

            int i = 0;
            while (cmd.name.length() + i < 10) {
                System.out.print(" ");
                i++;
            }
            System.out.print("- " + cmd.description);
        }
        System.out.println("\n");
    }
}