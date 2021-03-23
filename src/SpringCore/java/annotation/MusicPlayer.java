package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MusicPlayer {
    private List<Music> musicList = new ArrayList<>();

    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    // IoC


    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
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

    public String playMusic() {
        Random random = new Random();
        return "Playing " + musicList.get(random.nextInt(musicList.size())).getSong();
    }

}
