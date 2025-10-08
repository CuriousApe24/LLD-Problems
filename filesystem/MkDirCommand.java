package filesystem;

public class MkDirCommand implements Command {
    @Override
    public void execute(String[] args, FileSystem fileSystem){
        if(args.length != 0){
            String dirName = args[0];
            Directory curDirectory = fileSystem.getCurrentDirectory();

            if(curDirectory.getEntityFromDir(dirName) != null){
                curDirectory.addEntityToDir(new Directory(dirName, curDirectory));
            }
            else{
                System.out.println("Directory already Exists");
            }
        }
    }
}
