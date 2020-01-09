import org.newdawn.slick.*;
//import org.newdawn.slick.geom.Rectangle;
//import org.newdawn.slick.geom.Shape;
//import java.util.ArrayList;
public class TerrainTest extends BasicGame{
 Terrain map;
 public TerrainTest(String title){
 super (title);
 }
 public void init(GameContainer gc) throws SlickException{
     map=new Terrain();
 }
 public void update(GameContainer gc, int i) throws SlickException{
}
 public void render (GameContainer gc, Graphics g)throws SlickException{
   map.draw();
   map.drawGrid(g);
 }
}
