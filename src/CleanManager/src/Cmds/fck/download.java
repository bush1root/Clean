package Cmds.fck;

import Cmds.Command;
import Utils.Logs;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class download extends Command {
    public download() {
        super("download", "Download last version", "download");
    }

    @Override
    public void run(String[] args) {
        System.out.println();
        Logs.sendInfo("Version: 1.16.5");
        Logs.sendInfo("Download modification...");
        try (BufferedInputStream inputStream = new BufferedInputStream(new URL("https://clowdy.space/clean/mod.jar").openStream());
             FileOutputStream ff = new FileOutputStream("mod.jar")) {
            byte[] data = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                ff.write(data, 0, byteContent);
            }
        } catch (IOException ignored) {}
        Logs.sendSuccess("File successfully downloaded :)");
        System.out.println();
    }
}