

/*
    Name:Adaptor Pattern
    Type: Structural Pattern
    Use: Suppose we have an existing interface with the client, that is working
    Now we want to use a new interface but it is incompetable with the client
    What should we do?
    Should we change the existing code, or change the incompetable code? No
    We create a adaptor, for the new interface that implements the current interface, so that client should not know what happend behind
    And new interface could be added easily
 */
interface FileParser{
    void readFile(String s);
    void saveFile();
}
class CSVFileParser implements FileParser{

    @Override
    public void readFile(String s) {
        //Read operations
    }

    @Override
    public void saveFile() {
        //Save operations
    }

}

//This is adaptee incompatible with the existing code so we create a adaptor
class XMLFileParser{
    public void readFromFile(String s){
        //Read operations
    }
    public void saveInFile(String s){
        //Save operations
    }
}

//I need to now create Adaptor for the XML FileParser
class XMLFileParserAdaptor implements FileParser{
    XMLFileParser xmlFileParser;
    XMLFileParserAdaptor(){
        xmlFileParser = new XMLFileParser();
    }
    @Override
    public void readFile(String s) {
        xmlFileParser.readFromFile(s);
    }

    @Override
    public void saveFile() {
        xmlFileParser.saveInFile("");
    }

}

public class AdaptorPattern {
    public static void main(String args[]){
        //Client works like this
        FileParser csvParser = new CSVFileParser();
        csvParser.readFile("");
        csvParser.saveFile();

        //Now the client can also work  with XMLFileParser
        FileParser xmlParser = new XMLFileParserAdaptor();
        xmlParser.readFile("");
        xmlParser.saveFile();
    }
}
