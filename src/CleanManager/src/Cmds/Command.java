package Cmds;

public class Command {
    public String name;
    public String description;
    public String alias;

    public Command(String name, String description, String alias) {
        this.name = name;
        this.description = description;
        this.alias = alias;
    }

    public void run(String[] args) {

    }
}