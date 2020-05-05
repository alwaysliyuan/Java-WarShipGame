package model;




import java.io.Serializable;

import javax.swing.ImageIcon;





public class Warship extends GameObject implements Serializable{


	
	public boolean alive=true; //ÊÇ·ñ´æ»î
    public int blood;
    public int shellA_num=5;
    public int shellB_num=10;
    public int shellC_num=15;
    

    
    public Warship(String s,int x,int y,int blood) {

		this.image=new ImageIcon(s).getImage();
		this.x=x;
		this.y=y;
		this.width=120;
		this.height=60;
		speed=10;
		this.blood=blood;
    }
    public Warship() {
    	this.width=60;
		this.height=30;
		speed=10;
    }
    
    public void setX(int x) {
		 if(x+width+speed>800) {
			  x=700-width-speed;
		  }
		  if(x<0) {
			  x=0;
		  }
		  this.x=x;
	}
    
	public void setY(int y) {
		if(y+height+speed>580) {
			  y=580-height-speed;
		  }
		  if(y<0) {
			  y=0;
		  }
		  this.y=y;
	}
	public void setBlood(int blood) {
		this.blood=blood;
	}
	public int getBlood() {
		return blood;
	}
}

   
