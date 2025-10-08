package filesystem;

import java.util.HashMap;

public class CommandHandler {
    HashMap<String, Command> mapOfCommands = new HashMap<>();

    public void registerCommands(String name, Command command){
        mapOfCommands.put(name, command);
    }

    public void executeCommand(String name, String[] args, FileSystem fS){
        if(mapOfCommands.containsKey(name)){
            Command command = mapOfCommands.get(name);
            command.execute(args, fS);
        }
    }
}
