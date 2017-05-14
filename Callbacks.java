import com.sun.glass.ui.MenuItem;
import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * Created by sameerraghuram on 4/25/17.
 */
public class Callbacks {

    // Singleton private instance
    private static Callbacks instance = null;

    // Data
    private HashMap<String, Consumer<String>> callbacks = null;

    // Private constructor
    private Callbacks(){
        callbacks = new HashMap<>();
    }

    // Singl
    static Callbacks getInstance(){
        if(instance == null){
            instance = new Callbacks();
        }

        return instance;
    }

    // Collection interface
    public void put(String key, Consumer<String> function){
        callbacks.put(key, function);
    }

    public void exec(String key, String message) throws Exception {
        callbacks.get(key).accept(message);
    }

}
