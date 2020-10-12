package engineTester;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameLoop {

    public static void main(String[] args) throws LWJGLException {
        DisplayManager.createDisplay();
        Loader loader = new Loader();
        Renderer renderer = new Renderer();

        //model definition
        float[] vertices = {
                -0.5f, 0.5f, 0f,
                -0.5f, -0.5f, 0f,
                0.5f, -0.5f, 0f,
                0.5f, 0.5f, 0f
        };

        int[] indices = {
          0,1,3, //Top left triangle (Vo,V1,V3)
          3,1,2  //Bottom right triangle (V3,V1,V2
        };

        RawModel model = loader.loadToVAO(vertices, indices);

        while(!Display.isCloseRequested()){
            // game logic
            renderer.prepare();
            renderer.render(model);
            DisplayManager.updateDisplay();
        }

        loader.cleanUp();
        DisplayManager.closeDisplay();
    }
}
