import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext contextJunior = new AnnotationConfigApplicationContext(BeanConfigJunior.class);
        ApplicationContext contextMiddle = new AnnotationConfigApplicationContext(BeanConfigMiddle.class);
        ApplicationContext contextSenior = new AnnotationConfigApplicationContext(BeanConfigSenior.class);

        Programmer junior = contextJunior.getBean(Programmer.class);
        Programmer middle = contextMiddle.getBean(Programmer.class);
        Programmer senior = contextSenior.getBean(Programmer.class);

        junior.doCoding();
        middle.doCoding();
        senior.doCoding();

    }
}
