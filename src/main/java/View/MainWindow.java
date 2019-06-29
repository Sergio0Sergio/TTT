
package View;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;
import javax.swing.JFrame;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MainWindow extends JFrame {

  private BufferedImage buffer;
  private int[] bufferData;
  private Graphics bufferGraphics;
  private int clearColor;

public MainWindow(@Value("${width}") int width,
    @Value("${height}") int height,
    @Value("${title}") String title, int _clearColor){

  Canvas content = new Canvas();
  Dimension size = new Dimension(width, height);
  content.setPreferredSize(size);
  setResizable(false);
  setTitle(title);
  getContentPane().add(content);
  pack();

  setDefaultCloseOperation(EXIT_ON_CLOSE);
  buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
  bufferData = ((DataBufferInt) buffer.getRaster().getDataBuffer()).getData();
  bufferGraphics = buffer.getGraphics();
  clearColor = _clearColor;
}

public void clear(){
  Arrays.fill(bufferData, clearColor);
}

public void render(){

}

public void swapBuffers(){

}


}
