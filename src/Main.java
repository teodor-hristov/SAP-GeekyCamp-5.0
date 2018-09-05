import java.util.ArrayList;
import java.util.List;
import java.lang.System;

public class Main {
    public static void createDirectory(String directoryName) {
        Directory newDir = new Directory();
        newDir.setName(directoryName);
    }

    public static void setParent(Directory current, Directory parent) {
        current.setParent(parent);
    }

    public static void main(String[] args) {


    }


}
