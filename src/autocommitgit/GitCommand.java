/*
 * command of git
 */
package autocommitgit;

/**
 * command of git
 * @author hoaiv
 */
public class GitCommand {
    private static final String GIT_ADD = "git add ";
    private static final String GIT_COMMIT = "git commit -m ";
    private static final String GIT_STATUS = "git status";
    private static final String GIT_VERSION = "git --version"; 
    private static final String GIT_INIT = "git init "; 
    
    
    private static final CMD cmd =  new CMD();
    /**
     * get version of current git on windows
     * @return version
     */
    public static String getGitVersion(){
        return cmd.execCMD(GIT_VERSION);
    }
    // git init
    public static Boolean init(String folderPath){
        if( isGit() ){
            cmd.execCMD( GIT_INIT, folderPath );
            return true;
        }
        return false;
    }
    // check CMD has git
    public static Boolean isGit(){
        String version = getGitVersion();
        return version.length() < 45;
    }
    // git add
    public static String add(String folderPath){
        String result = cmd.execCMD( GIT_ADD + "*", folderPath);
        if(  (result !=  null) ){
            if(  result.contains("fatal: Not a git repository") ){
                init(folderPath);
            }
            result = cmd.execCMD( GIT_ADD + "*", folderPath);
        }
        return  "oke";
    }
    // git commit
    public static Boolean commit(String message, String folderPath){
        GitCommand.add(folderPath);
        String messageComit = GIT_COMMIT + "\" " + message + " \"";
        String result =  cmd.execCMD(messageComit, folderPath);
        return (result != null && result.contains("["));
    }
    // git status
    public static String status(String folderPath){
        String result =  cmd.execCMD(GIT_STATUS, folderPath);
        if( result == null ){
            cmd.execCMD(GIT_INIT, folderPath);
            result =  cmd.execCMD(GIT_STATUS, folderPath);
        }else
        if( result.contains("nothing to commit") || result.contains("fatal: Not a git") ){
            return null;
        }
        return cmd.execCMD(GIT_STATUS, folderPath);
    }
    
    
    
    
    
    
}
