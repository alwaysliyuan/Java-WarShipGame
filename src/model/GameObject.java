package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class GameObject {
	protected int x;    //x����  
    protected int y;    //y����  
    protected int width;    //��  
    protected int height;   //��  
    protected Image image;   //ͼƬ  
	public int speed;//�ٶ�
	   


	
	public GameObject() {
	}
	
	/**
	 * �����������ڵľ��Ρ����ں�������ײ���
	 * @return
	 */
	public  Rectangle   getRect(){
		return  new Rectangle((int)x, (int)y, width, height);
	}
	
    public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(String s) {
		this.image=new ImageIcon(s).getImage();
	}
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
	public void setWidth(int width) {
		this.width=width;
	}
	public void setHeight(int height) {
		this.height=height;
	} 
}

