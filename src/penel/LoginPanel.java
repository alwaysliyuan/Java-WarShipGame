package penel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class LoginPanel extends JPanel{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -5016190258704594717L;
	private GameFrame frame;
	 Image image;
	 JButton bt1,bt2,bt3;
	 public LoginPanel() {
		 
	 }
	public LoginPanel(GameFrame frame)
	{
		this.setVisible(true);
		final LoginPanel thisPanel=this;
		image=new ImageIcon("src/image/timg.jpg").getImage(); 

		this.frame=frame;
		frame.requestFocus();
		this.setLayout(null);

		bt1=new JButton("开始新游戏");
		bt1.setBounds(350,250 ,120,30);
		this.add(bt1);
		bt2=new JButton("读取游戏存档");
		bt2.setBounds(350,300 ,120,30);
		this.add(bt2);
		bt3=new JButton("游戏规则");
		bt3.setBounds(350,350 ,120,30);
		this.add(bt3);
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				GamePanel gamePanel=new GamePanel(frame,false);
				thisPanel.setVisible(false);
				frame.setPanel(gamePanel);
			}
			
		});
		
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				GamePanel gamePanel;

					gamePanel = new GamePanel(frame,true);
					thisPanel.setVisible(false);
					frame.setPanel(gamePanel);
					frame.addKeyListener(gamePanel);

				
			}
			
		});

		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Instruction ins =new Instruction(frame);
				thisPanel.setVisible(false);
				frame.setPanel(ins);	
			}
		});
		}


	protected void paintComponent(Graphics g) {  
		
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);  
		Font font=new Font("黑体",Font.BOLD,50);
		g.setFont(font);
		g.setColor(Color.orange);
		g.drawString("战舰游戏", 310, 200);
		} 

}
