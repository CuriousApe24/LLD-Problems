package filesystem;

import java.util.ArrayList;

public class LsCommand implements Command{
    @Override
    public void execute(String[] args, FileSystem fileSystem){
        ArrayList<Entity> entities = fileSystem.getCurrentDirectory().getContents();
        for(Entity ent: entities){
            System.out.println(ent.getName());
        }
    }
}
