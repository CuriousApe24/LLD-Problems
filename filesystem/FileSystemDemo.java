package filesystem;

public class FileSystemDemo {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();

        fs.executeCommand("mkdir", new String[]{"Documents"});
        // fs.executeCommand("cd", new String[]{"Documents"});
        fs.executeCommand("touch", new String[]{"file1.txt"});
        fs.executeCommand("ls", new String[]{});
        // fs.executeCommand("cd", new String[]{".."});
        fs.executeCommand("ls", new String[]{});
        fs.executeCommand("find", new String[]{"Main.java"});
    }
}
