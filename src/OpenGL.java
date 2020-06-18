import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import com.jogamp.opengl.util.FPSAnimator;



public class OpenGL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      //getting the capabilities object of GL2 profile  
      
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
   
      // The canvas
      final GLCanvas glcanvas = new GLCanvas(capabilities);
      Transformation drawing = new Transformation();
      glcanvas.addGLEventListener(drawing);
      glcanvas.setSize(400, 400);
   
      //creating frame
      final JFrame frame = new JFrame ("transformation");
   
      //adding canvas to frame
      frame.addKeyListener((java.awt.event.KeyListener)drawing);
      frame.getContentPane().add(glcanvas);
      frame.setSize(frame.getContentPane().getPreferredSize());
      frame.setVisible(true);
      FPSAnimator animator = new FPSAnimator(glcanvas,60);
      animator.start();
   }
    
}