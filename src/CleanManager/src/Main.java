import Cmds.CommandManager;
import Utils.Logs;
import conf.conf;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Scanner;

import static Utils.Logs.CYAN;
import static Utils.Logs.YELLOW;

public class Main {
    public static void main(String[] args) {
        new CommandManager().setup();

        System.out.println(CYAN + "  __            \n" +
                " /   |  _  _ __ \n" +
                " \\__ | (/_(_|| |" + YELLOW + "\n Author: bush1root\n");

        Logs.sendInfo("Checking for updates...");

        try {
            if (!Jsoup.connect("https://clowdy.space/clean/version").get().text().equals(conf.version)) {
                Logs.sendInfo("Update Found! Download: https://github.com/bush1root/Clean");
            } else {
                Logs.sendInfo("No updates founds");
            }
        } catch (IOException ignored) {}
        System.out.println();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print(" ~> ");
            String cmd = sc.nextLine();
            new CommandManager().onCommand(cmd);
        }
    }
}
