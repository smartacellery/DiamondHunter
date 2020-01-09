import org.newdawn.slick.*;
public class SpriteFun extends BasicGame{
 SpriteSheet gsprite;
 Animation ani[] = new Animation[4];
 Image walk [][]= new Image [4][4];
 Image stopImage[]= new Image [4];
 int guyx=100, guyy=100;
 int dir=3;
 boolean stop=true;
 public SpriteFun (String title){
     super(title);
 }
 public void init(GameContainer gc) throws SlickException{
     gsprite= new SpriteSheet("data/george.png", 48,48);
     gsprite.startUse();
     for (int i=0; i<4; i++){
         stopImage[i]=gsprite.getSubImage(i,0);
         for (int j=0; j<4; j++){
             walk[i][j]=gsprite.getSubImage(i,j);
         }
     ani[i]=new Animation(walk[i],100);
     }     
 }
 public void update(GameContainer gc, int i) throws SlickException{
     Input in=gc.getInput();
     stop=false;
     if(in.isKeyDown(Input.KEY_RIGHT)){
         guyx--;
         dir=1;
     }
     else if (in.isKeyDown(Input.KEY_LEFT)){
         guyx--;
         dir=1;
     }
     else if (in.isKeyDown(Input.KEY_DOWN)){
         guyx++;
         dir=0;
      }
     else if (in.isKeyDown(Input.KEY_UP)){
         guyx--;
         dir=2;
      }
     else{
         stop=true;
         
     }
     }
     
public void render(GameContainer gc, Graphics g)  throws SlickException{
    //gsprite.startUse();
   // gsprite.getSprite(0,0).draw(100,100);
    //gsprite.getSprite(1, 0).draw(150,100);
    //gsprite.getSprite(2, 0).draw(200,100);
    //gsprite.getSprite(3, 0).draw(250,100);
    //gsprite.endUse() ;
    if(stop){
        ani[dir].stop();
        stopImage[dir].draw(guyx,guyy);
    }
    else{
        ani[dir].start();
        ani[dir].draw(guyx,guyy);
    }
}
}

