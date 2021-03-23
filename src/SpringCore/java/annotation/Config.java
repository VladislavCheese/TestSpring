package annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
//@ComponentScan("annotation")
@PropertySource("classpath:musicPlayer.properties")
public class Config {
    @Bean
    public ClassicalMusic classicalMusic(){
        return new ClassicalMusic();
    }
    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();
    }
    @Bean
    public RapMusic rapMusic(){
        return new RapMusic();
    }
    @Bean
    public List<Music> listMusic(){
        return Arrays.asList(classicalMusic(),rapMusic(),rockMusic());
    }

    @Bean
    public MusicPlayer musicPlayer(){
        return new MusicPlayer(listMusic());
    }
}
