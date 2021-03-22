package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component
public class MusicPlayer {
    private List<Music> rockList = new ArrayList<>();
    private List<Music> rapList = new ArrayList<>();
    private List<Music> classicalList = new ArrayList<>();
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    // IoC
    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") List<Music> rockList, @Qualifier("rapMusic") List<Music> rapList, @Qualifier("classicalMusic") List<Music> classicalList ) {
        this.rockList = rockList;
        this.rapList = rapList;
        this.classicalList = classicalList;
    }

    @PostConstruct
    private void doMyInit(){
        System.out.println("Init");
    }

    @PreDestroy
    private void doMyDestroy(){
        System.out.println("Destroy");
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public MusicPlayer() {}

//    public void playMusic() {
//        for (Music music: musicList) {
//            System.out.println("Playing: " + music.getSong());
//            int count = 0;
//            while (count < 4) {
//                System.out.print(".");
//                count++;
//                try {
//                    Thread.sleep(400);
//                } catch (InterruptedException e) {
//                }
//            }
//            System.out.println();
//        }
//    }
private void playRapMusic() {
        for (Music music: rapList) {
            System.out.println("Playing: " + music.getSong());
            int count = 0;
            while (count < 4) {
                System.out.print(".");
                count++;
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                }
            }
            System.out.println();
        }
    }

    private void playRockMusic() {
        for (Music music: classicalList) {
            System.out.println("Playing: " + music.getSong());
            int count = 0;
            while (count < 4) {
                System.out.print(".");
                count++;
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                }
            }
            System.out.println();
        }
    }
    private void playClassicalMusic() {
        for (Music music: rockList) {
            System.out.println("Playing: " + music.getSong());
            int count = 0;
            while (count < 4) {
                System.out.print(".");
                count++;
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                }
            }
            System.out.println();
        }
    }
    public void playMusic(TypeOfMusic type) {
        if (type == TypeOfMusic.RAP) {
            playRapMusic();
        } else if (type == TypeOfMusic.ROCK) {
            playRockMusic();
        } else if (type == TypeOfMusic.CLASSICAL) {
            playClassicalMusic();
        }
    }
}
