package model;

import javax.swing.ImageIcon;

public class ShellA extends Shell{
	
	public ShellA(String direction) {
		super();
		range=600;
		killblood=3;
		if(direction=="UP")
			this.image=new ImageIcon("src/image/ShellA_UP.png").getImage();
		else
			this.image=new ImageIcon("src/image/ShellA_DOWN.png").getImage();
		setWidth(10);
		setHeight(40);
	}

}
