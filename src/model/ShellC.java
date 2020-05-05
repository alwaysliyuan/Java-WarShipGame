package model;

import javax.swing.ImageIcon;

public class ShellC extends Shell{
	
	public ShellC(String direction) {
		super();
		killblood=1;
		range=300;
		if(direction=="UP")
			this.image=new ImageIcon("src/image/ShellC_UP.png").getImage();
		else
			this.image=new ImageIcon("src/image/ShellC_DOWN.png").getImage();
		setWidth(10);
		setHeight(30);
	}
}