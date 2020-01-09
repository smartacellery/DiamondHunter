import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import org.newdawn.slick.*;

public class GameOverScreen extends BasicGameState{
    static String message="Not Set";
    static int msgx=100;
    public void init(GameContainer gc, StateBasedGame sbg){
        
    }
    public static void setMessage(String msg, int x){
    message=msg;
msgx=x;    
    }
    public void update(GameContainer gc,StateBasedGame sbg, int i)throws SlickException{
    }
    public void render(GameContainer gc,StateBasedGame sbg, Graphics g) throws SlickException{
        g.setColor(Color.green);
        g.drawString("GAME OVER", 300, 150);
        g.drawString(message,msgx,200);
        g.drawRoundRect(80,190,600,40,20);
        
    }
    public int getID(){
        return 2;
    }
    
}