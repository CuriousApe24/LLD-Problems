package filesystem;

import java.util.ArrayList;

public class FindCommand implements Command {
    @Override
    public void execute(String[] args, FileSystem fileSystem){
        if(args.length<1){
            System.out.println("Invalid use of find command");
            return;
        }
        String targetName = args[0];
        Directory root = fileSystem.getCurrentDirectory();

        ArrayList<String> result = new ArrayList<>();
        findHelper(targetName, result, root, new StringBuilder());
        if(result.size() == 0) {
            System.err.println("No files found\n");
            return;
        }
        else{
            for(String re: result) System.out.println(re);
        }
    }
    private void findHelper(String target, ArrayList<String> result, Directory dir, StringBuilder path){
        for (Entity entity : dir.getContents()) {
            path.append("/"+entity.getName());
            if (entity.getName().equals(target)) {
                result.add(path.toString());
            }
            if (entity instanceof Directory) {
                findHelper(target, result, (Directory) entity, path);
            }
        }
    }
}
