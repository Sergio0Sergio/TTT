package View;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MainWindow extends JFrame {

public MainWindow(@Value("${width}") int width,
    @Value("${height}") int height,
    @Value("${title}") String title){

  Canvas content = new Canvas();
  Dimension size = new Dimension(width, height);
  content.setPreferredSize(size);
  setResizable(false);
  setTitle(title);
  getContentPane().add(content);
  pack();
  setDefaultCloseOperation(EXIT_ON_CLOSE);

}


}
