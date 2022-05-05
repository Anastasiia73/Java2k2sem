import org.springframework.stereotype.Component;

@Component
public class Programmer {
    private IProgrammer programmer;

    public void doCoding(){
        System.out.println(programmer.doCoding() + " is codding...");
    }

    public void setProgrammer(IProgrammer programmer) {
        this.programmer = programmer;
    }
}
