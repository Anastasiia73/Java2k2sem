import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigJunior {
    @Bean
    public Junior junior(){
        return new Junior();
    }

    @Bean
    public Programmer juniorProgrammer(IProgrammer programmer){
        Programmer junior = new Programmer();
        junior.setProgrammer(programmer);
        return junior;
    }
}
