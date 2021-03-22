package org.xml;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private List<Music> musicList = new ArrayList<>();

    private String name;
    private int volume;

    public void doMyInit(){
        System.out.println("Initialization");
    }

    public void doMyDestroy(){
        System.out.println("Destruction");
    }
    // IoC
    private MusicPlayer(List<Music> music) {
        this.musicList = music;
    }

    private MusicPlayer() {}

    public static MusicPlayer factory(List<Music> music) {
        return new MusicPlayer(music);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void playMusic() {
        for(Music music: musicList) {
            System.out.println("Playing: " + music.getSong());
            int count = 0;
            while(count < 4){
                System.out.print(".");
                count++;
                try{
                    Thread.sleep(400);
                } catch (InterruptedException e){}
            }
            System.out.println();
        }
    }
}
