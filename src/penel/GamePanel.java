package penel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

import model.Shell;
import model.ShellA;
import model.ShellB;
import model.ShellC;
import model.Warship;


public class GamePanel extends JPanel implements KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6561678539295163722L;
	private GameFrame frame;
	int shootState=0;//����˭���
	Warship ship1,ship2;
	Shell  shell;//�����ڵ�
	Image background=new ImageIcon("src/image/bg.jpg").getImage();
	Image boom=new ImageIcon("src/image/boom.png").getImage();
	Image gameOver=new ImageIcon("src/image/GameOver.png").getImage();
	Image gameOver2=new ImageIcon("src/image/GameOver2.png").getImage();
	FreshThread t;

	public GamePanel(GameFrame frame,boolean load){
		ship1=new Warship("src/image/player1.png",300,0,20);
		ship2=new Warship("src/image/player2.png",300,500,20);
		if(load==true) {
			try {
				this.loadGame();
			} catch (ClassNotFoundException | IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
			
		shell=new Shell();
		this.frame=frame;
		frame.requestFocus();
		frame.addKeyListener(this);
		 t=new FreshThread();
		t.start();
	}
	

	
	public void loadGame() throws FileNotFoundException, IOException, ClassNotFoundException{
		 ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/data.txt"));
		 //�������һ������
		 ship1.setX((int)ois.readInt());
		 ship1.setY((int)ois.readInt());
		 ship1.setBlood((int)ois.readInt());
		 ship1.shellA_num=(int)ois.readInt();
		 ship1.shellB_num=(int)ois.readInt();
		 ship1.shellC_num=(int)ois.readInt();
		//������Ҷ�������
		 ship2.setX((int)ois.readInt());
		 ship2.setY((int)ois.readInt());
		 ship2.setBlood((int)ois.readInt());
		 ship2.shellA_num=(int)ois.readInt();
		 ship2.shellB_num=(int)ois.readInt();
		 ship2.shellC_num=(int)ois.readInt();
		 ois.close();
	}

	
	
	public void saveGame() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/data.txt"));
		//��¼���һ������
		oos.writeInt(ship1.getX());
		oos.writeInt(ship1.getY());
		oos.writeInt(ship1.getBlood());
		oos.writeInt(ship1.shellA_num);
		oos.writeInt(ship1.shellB_num);
		oos.writeInt(ship1.shellC_num);
		//��¼��Ҷ�������
		oos.writeInt(ship2.getX());
		oos.writeInt(ship2.getY());
		oos.writeInt(ship2.getBlood());
		oos.writeInt(ship2.shellA_num);
		oos.writeInt(ship2.shellB_num);
		oos.writeInt(ship2.shellC_num);
		
	    oos.close();
	}
	
	
	@Override
	public void paint(Graphics g) {
		paintImage(g);
		paintShip(g);
		paintShell(g);
		paintGameOver(g);
	}

	private void paintGameOver(Graphics g) {
		Font font1=new Font("����",Font.BOLD,50);
		g.setFont(font1);
		g.setColor(Color.orange);
		
		if(ship1.alive==false) {//���һ����
			g.drawImage(gameOver,0,0,this.getWidth(), this.getHeight(), this);
			g.drawString("��Ҷ�ʤ��!", 250, 300);
			
		}
		else if(ship2.alive==false) {//��Ҷ�����
			g.drawImage(gameOver,0,0,this.getWidth(), this.getHeight(), this);
			g.drawString("���һʤ��!", 250, 300);
		}
		else if(ship1.shellA_num==0&&ship1.shellB_num==0&&ship1.shellC_num==0
				&&ship2.shellA_num==0&&ship2.shellC_num==0&&ship2.shellB_num==0
				&&ship2.shellC_num==0) {
			g.drawImage(gameOver2,0,0,this.getWidth(), this.getHeight(), this);
			g.drawString("ƽ��", 350, 200);
		}
		
	}

	private void paintImage(Graphics g)//��������
	{   
		g.drawImage(background, 0, 0,this.getWidth(), this.getHeight(), this);
		Font font1=new Font("����",Font.BOLD,10);
		g.setFont(font1);
		g.setColor(Color.red);
		g.drawString("���1", 0, 15);
		
		g.drawString("Ѫ��: "+ship1.blood, 0, 30);

		g.drawString("�ڵ�A������:"+ship1.shellA_num, 0, 45);
	
		g.drawString("�ڵ�B������:"+ship1.shellB_num, 0, 60);
		g.drawString("�ڵ�C������:"+ship1.shellC_num, 0, 75);
		g.setColor(new Color(148,0,211));
		g.drawString("���2", 600, 15);
		g.drawString("Ѫ��: "+ship2.blood, 600, 30);
	
		g.drawString("�ڵ�A������:"+ship2.shellA_num, 600, 45);
		g.drawString("�ڵ�B������:"+ship2.shellB_num, 600, 60);
		g.drawString("�ڵ�C������:"+ship2.shellC_num, 600, 75);
	}
	

	private void paintShell(Graphics g){
		int range;
		g.drawImage(shell.getImage(),shell.getX(),shell.getY(),shell.getWidth(),shell.getHeight(),null);

		if(shell.getY()<600&&shootState==1) {//��ʾ���һ�������ڵ�	
			
			shell.setY(shell.getY()+20);
			range=Math.abs(ship1.getY()-shell.getY());//�������
			if(shell.range>=range) {
				if(ship2.getRect().intersects(shell.getRect())){
					//������һ���ڵ�����Ҷ���ս����ײ
						ship2.blood-=shell.killblood;
						shell.setX(1200);
						shell.setY(1200);
						g.drawImage(boom, ship2.getX(), ship2.getY(), 100, 100,null);
						if(ship2.blood<=0) {
							ship2.alive=false;
						}
					}
			 }
			else {
				shell.setX(1200);
				shell.setY(1200);
			}
		}
		if(shell.getY()<600&&shootState==2) {//��ʾ��Ҷ��������ڵ�
			shell.setY(shell.getY()-20);
			range=Math.abs(ship2.getY()-shell.getY());
			if(shell.range>=range) {
				if(ship1.getRect().intersects(shell.getRect()))
				{	
					ship1.blood-=shell.killblood;
					shell.setX(1200);
					shell.setY(1200);
					g.drawImage(boom, ship1.getX(), ship1.getY(), 100, 100,null);
					if(ship1.blood<=0) {
						ship1.alive=false;
					} 
				}
			}
			else {
				shell.setX(1200);
				shell.setY(1200);
			}
		}
	}
	

	
	private void paintShip(Graphics g){
		if(ship1.blood!=0)
			g.drawImage(ship1.getImage(),ship1.getX(),ship1.getY(),ship1.getWidth(),ship1.getHeight(),null);
		if(ship2.blood!=0)
			g.drawImage(ship2.getImage(),ship2.getX(),ship2.getY(),ship2.getWidth(),ship2.getHeight(),null);
		
	}
	

	 

	
	private class FreshThread extends Thread{
		public void run(){
			while(true){
				try{
					Thread.sleep(40);
					repaint();
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}	
			}
		}
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		//�������һ
		
		if(KeyEvent.VK_W==e.getKeyCode()) {//��
			ship1.setY(ship1.getY()-ship1.speed);
	
		}
		else if(KeyEvent.VK_S==e.getKeyCode()) {//��
			ship1.setY(ship1.getY()+ship1.speed);
		}
		else if(KeyEvent.VK_A==e.getKeyCode()) {//��
			ship1.setX(ship1.getX()-ship1.speed);
		}
		else if(KeyEvent.VK_D==e.getKeyCode()) {//��
			ship1.setX(ship1.getX()+ship1.speed);

		}
		else if(KeyEvent.VK_Z==e.getKeyCode()) {//���䳤����ڵ�A
			if(ship1.shellA_num>0) {
				shell=new ShellA("DOWN");
				shootState=1;
				ship1.shellA_num-=1;
				shell.setX(ship1.getX()+25);
				shell.setY(ship1.getY()+30);
			}
		}
		else if(KeyEvent.VK_X==e.getKeyCode()) {//����������ڵ�B
			if(ship1.shellB_num>0) {
				shell=new ShellB("DOWN");
				shootState=1;
				ship1.shellB_num-=1;
				shell.setX(ship1.getX()+25);
				shell.setY(ship1.getY()+30);
			}	
		}
		
		else if(KeyEvent.VK_C==e.getKeyCode()) {//���������ڵ�C
			if(ship1.shellC_num>0) {
				shell=new ShellC("DOWN");
				shootState=1;
				ship1.shellC_num-=1;
				shell.setX(ship1.getX()+25);
				shell.setY(ship1.getY()+30);
			}	
		}
		//������Ҷ�
		
		else if(KeyEvent.VK_UP==e.getKeyCode()) {//��
			ship2.setY(ship2.getY()-ship2.speed);
		}
		else if(KeyEvent.VK_DOWN==e.getKeyCode()) {//��
			ship2.setY(ship2.getY()+ship2.speed);
		}
		else if(KeyEvent.VK_RIGHT==e.getKeyCode()) {//��
			ship2.setX(ship2.getX()+ship2.speed);
		}
		else if(KeyEvent.VK_LEFT==e.getKeyCode()) {//��
			ship2.setX(ship2.getX()-ship2.speed);
		}
			
		else if(KeyEvent.VK_COMMA==e.getKeyCode()) {//���䳤����ڵ�A
			if(ship2.shellA_num>0) {
				shell=new ShellA("UP");
				shootState=2;
				ship2.shellA_num-=1;
				shell.setX(ship2.getX()+25);
				shell.setY(ship2.getY()+30);
			}
		}
		else if(KeyEvent.VK_PERIOD==e.getKeyCode()) {//����������ڵ�B
			if(ship2.shellB_num>0) {
				shell=new ShellB("UP");
				shootState=2;
				ship2.shellB_num-=1;
				shell.setX(ship2.getX()+25);
				shell.setY(ship2.getY()+30);
			}
		}
		else if(KeyEvent.VK_SLASH==e.getKeyCode()) {//���������ڵ�C
			if(ship2.shellC_num>0) {
				shell=new ShellC("UP");
				shootState=2;
				ship2.shellC_num-=1;
				shell.setX(ship2.getX()+25);
				shell.setY(ship2.getY()+30);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO �Զ����ɵķ������
	
		
	}

}
