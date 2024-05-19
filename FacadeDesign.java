
interface VideoMakerFacade{
    Video generateVideo();
}

interface VideoMakerHelper{
    void doAction();
}

class AudioMixer implements VideoMakerHelper{

    @Override
    public void doAction(){
        System.out.println("Mixing audio...");
    }
}
class VideoCompressor implements VideoMakerHelper{
    @Override
    public void doAction(){
        System.out.println("Compressing video...");
    }
}
class Codec implements VideoMakerHelper{
    @Override
    public void doAction(){
        System.out.println("Codec....");
    }
}
class Video{
    //We can have multiple fields
    //Such as audio
    void play(){
        System.out.println("Playing video...");
    }
}
class VideoMaker implements VideoMakerFacade{
    AudioMixer a = new AudioMixer();
    VideoCompressor v = new VideoCompressor();
    Codec c = new Codec();
    @Override
    public Video generateVideo() {
        a.doAction();
        v.doAction();
        c.doAction();
        return new Video();
    }
    
}
public class FacadeDesign{
    public static void main(String args[]){
        VideoMakerFacade vm = new VideoMaker();
        Video v = vm.generateVideo();
        v.play();
    }
}