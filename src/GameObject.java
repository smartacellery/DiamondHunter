//import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
//import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
//import org.newdawn.slick.geom.Shape;
import java.util.ArrayList;
abstract public class GameObject {
    protected Rectangle hitbox;
    protected Image image;
    public GameObject(int x, int y, String imgname) throws SlickException{
        image=new Image(imgname);
        hitbox=new Rectangle(x,y,image.getHeight(),image.getWidth());
    }
    abstract public void move(ArrayList<Rectangle> barriers);
    public void draw(){
        image.draw(hitbox.getX(),hitbox.getY());
    }
    public Rectangle getHitbox(){
        return hitbox;
    }
    
}
