package filesystem;

public abstract class Entity {
    private String name;
    protected Directory parent;

    public Entity(String name, Directory parent){
        this.name = name;
        this.parent = parent;
    }

    public String getName(){
        return name;
    }
}
