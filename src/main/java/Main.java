import View.MainWindow;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

  @Autowired
  MainWindow display;
  ActionListener actionListener;


  public static void main(String[] args){

    SpringApplication.run(Main.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

  }
}
