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
		JButton bt1=new JButton("������Ϸ��ҳ��");
		bt1.setBounds(350,400 ,120,30);
		this.add(bt1);
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				LoginPanel loginPanel=new LoginPanel(frame);
				thisPanel.setVisible(false);
				frame.setPanel(loginPanel);
			}
		
		});

	}
protected void paintComponent(Graphics g) {  
		
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);  
		Font font1=new Font("����",Font.BOLD,20);
		g.setFont(font1);
		g.setColor(Color.ORANGE);
		g.drawString("��Ϸ����", 350, 50);
		Font font2=new Font("����",Font.BOLD,15);
		g.setFont(font2);
		g.drawString("���һ��ͨ��W��A��S��D���������������ƶ�,", 30, 100);
		g.drawString("ͨ��Z��X��C���ֱ��䳤��̡�����̡�������ڵ���",30,120);
		g.drawString("��Ҷ���ͨ���ϡ��¡����ҷ�����������������ƶ���",30,150);
		g.drawString("ͨ�����š���š��ʺż��ֱ��䳤��̡�����̡�������ڵ���",30,170);
		g.drawString("����̵��ڵ��˺�ֵ��3��Ѫ��������̵��ڵ��˺�ֵ��2��Ѫ��������̵��ڵ��˺�ֵ��1��Ѫ����",30,220);
		}
}


