package filesystem;

public class FileSystem {
    private Directory root;
    private Directory current;
    CommandHandler commandHandler;

    FileSystem(){
        root = new Directory("/", null);
        current = root;
        commandHandler = new CommandHandler();
        registerCommands();
    }
    private void registerCommands(){
        commandHandler.registerCommands("mkdir", new MkDirCommand());
        commandHandler.registerCommands("ls", new LsCommand());
        commandHandler.registerCommands("touch", new TouchCommand());
        commandHandler.registerCommands("find", new FindCommand());
    }

    public Directory getRootDir(){
        return root;
    }
    public void setCurrentDirectory(Directory dir){
        current = dir;
    }

    public Directory getCurrentDirectory(){
        return current;
    }

    public void executeCommand(String command, String[] args){
        commandHandler.executeCommand(command, args, this);
    }

}
