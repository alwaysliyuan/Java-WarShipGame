package penel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Instruction extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6352595633648640439L;
	private GameFrame frame;

	Image image;
	
	public Instruction(GameFrame frame) {
		
		image=new ImageIcon("src/image/ins.jpg").getImage(); 
		this.setVisible(true);
		final Instruction thisPanel=this;
		this.frame=frame;
		frame.requestFocus();
		this.setLayout(null);
		JButton bt1=new JButton("返回游戏主页面");
		bt1.setBounds(350,400 ,120,30);
		this.add(bt1);
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				LoginPanel loginPanel=new LoginPanel(frame);
				thisPanel.setVisible(false);
				frame.setPanel(loginPanel);
			}
		
		});

	}
protected void paintComponent(Graphics g) {  
		
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);  
		Font font1=new Font("黑体",Font.BOLD,20);
		g.setFont(font1);
		g.setColor(Color.ORANGE);
		g.drawString("游戏规则", 350, 50);
		Font font2=new Font("黑体",Font.BOLD,15);
		g.setFont(font2);
		g.drawString("玩家一：通过W、A、S、D键进行上下左右移动,", 30, 100);
		g.drawString("通过Z、X、C键分别发射长射程、中射程、短射程炮弹。",30,120);
		g.drawString("玩家二：通过上、下、左、右方向键进行上下左右移动，",30,150);
		g.drawString("通过逗号、句号、问号键分别发射长射程、中射程、短射程炮弹。",30,170);
		g.drawString("长射程的炮弹伤害值是3个血量。中射程的炮弹伤害值是2个血量。短射程的炮弹伤害值是1个血量。",30,220);
		}
}


