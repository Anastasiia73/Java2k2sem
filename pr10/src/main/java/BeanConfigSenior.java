import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigSenior {
    @Bean
    public Senior senior(){
        return new Senior();
    }

    @Bean
    public Programmer seniorProgrammer(IProgrammer programmer){
        Programmer senior = new Programmer();
        senior.setProgrammer(programmer);
        return senior;
    }
}
