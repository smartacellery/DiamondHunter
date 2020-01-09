import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
//import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.Animation;
//import org.newdawn.slick.Image;
//import org.newdawn.slick.SpriteSheet;
//import org.newdawn.slick.*;
//import org.newdawn.slick.geom.Rectangle;
//import org.newdawn.slick.geom.Shape;
import java.util.ArrayList;
public class MainGame extends BasicGameState{
    int timer=0;
    Guy guy;
    ArrayList<GameObject> diamonds = new ArrayList();
    Terrain terrain;
    GameObject house;
    GameObject ghost,ghost2;
    
    public void init(GameContainer gc,StateBasedGame sb) throws SlickException{
    guy=new Guy(20,170);
    ghost= new Ghost(100,170,"data/ghost.png");
    ghost2= new Ghost(700,170,"data/ghost.png");
    house=new CollectItem(280,400,"data/house.png");
    terrain= new Terrain();
    for(int i=0;i<10;i++){
        GameObject d=new CollectItem(0,0,"data/diamond.png");
        ((CollectItem)d).place(terrain.getBarriers());
        diamonds.add(d);
    }
}
    
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException{
        Input in=gc.getInput();
        guy.move(in,terrain.getBarriers());
        timer++;
        for(int j=0;j<diamonds.size();j++){
            if(guy.isHitting(diamonds.get(j))){
                diamonds.remove(j);
                if(diamonds.isEmpty()&&terrain.hasExitRoad()==false){
                    terrain.addExitRoad();
                }
            }
        }
        if(guy.isHitting(ghost)||guy.isHitting(ghost2)){
            GameOverScreen.setMessage("You were captured by the ghosts - you LOSE!",200);
            sbg.enterState(2,new FadeOutTransition(), new FadeInTransition());
        }
        else if(guy.isHitting(house)){
            GameOverScreen.setMessage("You got all the diamonds and found your way home - you WIN!", 100);
            sbg.enterState(2,new FadeOutTransition(), new FadeInTransition());
        }
        if (timer==5){
            for (GameObject bd : diamonds) {
                bd.move(terrain.getBarriers());
            }
            timer=0;
        }
        if(timer%2==0){
            ghost.move(terrain.getBarriers());
            ghost2.move(terrain.getBarriers());
        }
    }
    public void render(GameContainer gc,StateBasedGame sbg, Graphics g) throws SlickException{
        terrain.draw();
        guy.draw();
        if(terrain.hasExitRoad())
            house.draw();
        for (GameObject dm : diamonds){
            dm.draw();
        }
        ghost.draw();
        ghost2.draw();
        
    }
    public int getID(){
        return 1;
    }
}
