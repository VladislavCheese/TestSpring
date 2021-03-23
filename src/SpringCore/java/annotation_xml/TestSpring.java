package annotation_xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "annotationApplicationContext.xml"
        );

        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        firstMusicPlayer.playMusic(TypeOfMusic.RAP);
        System.out.println(firstMusicPlayer.getName() + " " + firstMusicPlayer.getVolume());
        context.close();

    }
}
