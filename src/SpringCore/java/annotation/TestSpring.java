package annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                Config.class
        );
        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(firstMusicPlayer.playMusic());
        System.out.println(firstMusicPlayer.getName() + " " + firstMusicPlayer.getVolume());

        context.close();

    }
}
