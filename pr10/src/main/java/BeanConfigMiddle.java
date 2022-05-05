import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigMiddle {
    @Bean
    public Middle middle(){
        return new Middle();
    }

    @Bean
    public Programmer middleProgrammer(IProgrammer programmer){
        Programmer middle = new Programmer();
        middle.setProgrammer(programmer);
        return middle;
    }
}
