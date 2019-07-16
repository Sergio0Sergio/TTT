
package View;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;
import javax.swing.JFrame;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MainWindow extends JFrame {
  private Canvas content;
  private BufferedImage buffer;
  private int[] bufferData;
  private Graphics bufferGraphics;
  private int clearColor;

  private BufferStrategy bufferStrategy;

public MainWindow(@Value("${width}") int width,
    @Value("${height}") int height,
    @Value("${title}") String title, int _clearColor, int numBuffers){

  content = new Canvas();
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
  content.createBufferStrategy(numBuffers);
  bufferStrategy = content.getBufferStrategy();
}

public void clear(){
  Arrays.fill(bufferData, clearColor);
}

public void render(){
Graphics g = getContentPane().getGraphics();
g.drawImage(buffer, 0,0, null);
}

public void swapBuffers(){
  Graphics g = bufferStrategy.getDrawGraphics();
  g.drawImage(buffer, 0, 0, null);
  bufferStrategy.show();
}


}
