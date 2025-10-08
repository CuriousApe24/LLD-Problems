package filesystem;

public interface Command {
    public void execute(String[] args, FileSystem fileSystem);
}
