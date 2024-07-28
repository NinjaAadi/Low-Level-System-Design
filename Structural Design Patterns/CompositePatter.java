import java.util.*;

abstract class FileSystem{
    private Directory rootDirectory;
    Stack<Directory> openDirectories;
    Map<Integer,File>inodes;


    FileSystem(){
        rootDirectory = new UNIXDirectory();
    }
    protected void addToStack(){

    }
    abstract void cd(String folderPath);
    abstract void mkdir(String directoryName);
    abstract void rmdir(String directoryName);
    abstract void touch(String fileName);
    abstract void delete(String filename);
}
interface File{
    void write(String s);
    String read();
}

interface Directory{
    List<FileSystemElement> getFiles();
}
interface FileSystemElement{
    
}
class UNIXDirectory implements Directory, FileSystemElement{
    ArrayList<FileSystemElement> files;
    UNIXDirectory(){
        files = new ArrayList<>();
    }
    @Override
    public List<FileSystemElement> getFiles() {
        return files;
    }

}
class UNIXFIle implements File,FileSystemElement{
    private String data;
    UNIXFIle(){
        data = "";
    }
    @Override
    public void write(String s) {
        data+=s;
    }

    @Override
    public String read() {
        return data;
    }
    
}
class UNIXFileSystem extends FileSystem{

    @Override
    void cd(String folderPath) {
        super.addToStack();
    }

    @Override
    void mkdir(String directoryName) {
    
    }

    @Override
    void rmdir(String directoryName) {
    
    }

    @Override
    void touch(String fileName) {
        
    }

    @Override
    void delete(String filename) {
       
    }
}
/*
    interface CloudFileSystem{

    }
    class GCPFileSystem extends CloudFileSystem,FIleSystem{

    }
    abstract class CommonFileSystem{
        FileSystem fs;
        CommonFileSystem(FileSystem _fs){
            fs = _fs
        }
        void mkdir(){
            fs.mkdir();
        }
        void rmdir;
    }
    class MacFileSystem extends CommonFileSystem{
        MacFileSystem(FileSystem fs){
            super(fs);
        }   
    }
    Now I can call
    FileSystem gcp = new GCPFileSystem(); 
    CommonFileSystem macFileSystem = new MacFileSystem(gcp);
 */
public class CompositePatter {
    public static void main(String args[]){
        FileSystem unixFileSystem = new UNIXFileSystem();
        unixFileSystem.mkdir("a");
        unixFileSystem.cd("a");
        unixFileSystem.rmdir("a/b");
    }
}
