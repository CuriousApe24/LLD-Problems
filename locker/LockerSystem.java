package locker;

import java.util.HashMap;

public class LockerSystem {
    private HashMap<String, Locker> assignedLockers;
    private LockerManager lockerManager;

    public boolean assignLocker(Package pckg){
        Locker locker = lockerManager.findAvailableLocker(pckg);
    }
}
