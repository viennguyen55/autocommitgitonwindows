/*
 * Get name of OS
 */
package autocommitgit.other;

/**
 *
 * @author hoaiv
 */
public class OS {
    public Boolean isSupport(){
        String OS = System.getProperty("os.name").toLowerCase();
        return OS.contains("win");
    }
}
