package model;

import javax.swing.ImageIcon;

public class ShellB extends Shell{
	
	public ShellB(String direction) {
		super();
		killblood=2;
		range=400;
		if(direction=="UP")
			this.image=new ImageIcon("src/image/ShellB_UP.png").getImage();
		else
			this.image=new ImageIcon("src/image/ShellB_DOWN.png").getImage();
		setWidth(10);
		setHeight(40);
	}
}
