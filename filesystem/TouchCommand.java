package filesystem;

public class TouchCommand implements Command{
    @Override
    public void execute(String[] args, FileSystem fileSystem){
        if(args.length<1){
            System.out.println("Provide file name to create\n");
            return;
        }
        Directory curDirectory = fileSystem.getCurrentDirectory();
        String fileName = args[0];
        if(!fileName.contains(".")){
            System.out.println("invalid file name\n");
        }
        curDirectory.addEntityToDir(new File(fileName, curDirectory));
    }
}
