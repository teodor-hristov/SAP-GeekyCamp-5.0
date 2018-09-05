import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Directory {
    private HashMap<String, Directory> directories = new HashMap<>();
    private HashMap<String, String> files = new HashMap<>();

    public Directory() {
        directories = new HashMap<>();
        files = new HashMap<>();
    }

}
