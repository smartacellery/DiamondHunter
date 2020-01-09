
import org.newdawn.slick.Animation;

import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
//import org.newdawn.slick.geom.Shape;
import java.util.ArrayList;

public class Guy {
private Animation ani[]=new Animation[4];
private Image walk[][]=new Image[4][4];
private Image stopImage[]=new Image[4];
private SpriteSheet gsprite;
private boolean stopped;
private Rectangle hitbox;
private int dir;
public Guy(int x, int y) throws SlickException{
gsprite= new SpriteSheet("data/george.png",48,48);
gsprite.startUse();
for (int i=0;i<4;i++){
    stopImage[i]=gsprite.getSubImage(i,0);
    for(int j=0;j<4;j++){
        walk[i][j]=gsprite.getSubImage(i,j);
    }
    ani[i]=new Animation(walk[i],100);
}
gsprite.endUse();
hitbox=new Rectangle(x,y,26,30);
stopped=true;
dir=3;
}
public void move(Input kb,ArrayList<Rectangle> walls){
    stopped=false;
    int x=(int)hitbox.getX();
    int y=(int) hitbox.getY();
    int origx=x, origy=y;
    
    if(kb.isKeyDown(Input.KEY_RIGHT)&& x<800){
        x++;
        dir=3;
    }
    else if(kb.isKeyDown(Input.KEY_RIGHT)&& x==800){
        x=0;
        dir=3;
    }
    else if (kb.isKeyDown(Input.KEY_LEFT)&& x>0){
       x--;
        dir=1;
    }
    else if(kb.isKeyDown(Input.KEY_LEFT)&& x==0){
        x=800;
        dir=3;
    }
    else if (kb.isKeyDown(Input.KEY_DOWN)&& y<640){
       y++;
        dir=0;
    }else if(kb.isKeyDown(Input.KEY_DOWN)&& y==640){
        y=0;
        x=340;
        dir=3;
    }
    
    
    else if (kb.isKeyDown(Input.KEY_UP)&&y>0){
       y--;
        dir=2;
    }
    else if(kb.isKeyDown(Input.KEY_UP)&& y==0){
        y=640;
        x=110;
        dir=3;
    }else{
        stopped=true;            
    }
    hitbox.setX(x);
    hitbox.setY(y);
    
    if(isHitting(walls)){
        hitbox.setX(origx);
        hitbox.setY(origy);
    }
}
public boolean isHitting(ArrayList<Rectangle> rect){
    for(Rectangle r : rect) {
        if(hitbox.intersects(r)){
            return true;          
          }
    }return false;
}
public boolean isHitting(GameObject go){
    return hitbox.intersects(go.getHitbox());
}
public void draw(){
    if (stopped){
        ani[dir].stop();
        stopImage[dir].draw(hitbox.getX()-12, hitbox.getY()-12);
    }else{
        ani[dir].start();
        ani[dir].draw(hitbox.getX()-12,hitbox.getY()-12);
        //g.setColor(Color.red);
        //g.draw(hitbox);
    }

}
}

