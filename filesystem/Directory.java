package filesystem;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Directory extends Entity {
    private Map<String, Entity> filesAndDirs;

    Directory(String name, Directory dir){
        super(name, dir);
        this.filesAndDirs = new HashMap<>();
    }

    public void addEntityToDir(Entity entity){
        filesAndDirs.put(entity.getName(), entity);
    }

    public Entity getEntityFromDir(String name){
        if(!filesAndDirs.containsKey(name)) return null;
        return filesAndDirs.get(name);
    }

    public ArrayList<Entity> getContents(){
        ArrayList<Entity> entities = new ArrayList<>();
        for(Entity ent: filesAndDirs.values()) entities.add(ent);
        return entities;
    }

}
