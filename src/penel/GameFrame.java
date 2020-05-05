package penel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.*;



public class GameFrame extends JFrame {

	LoginPanel loginPanel;
	GamePanel gamePanel;
	Instruction insPanel;

    /** �˵���*/
    private JMenuBar menubar;
    /** �˵�1,2*/
    private JMenu    menu1;
    private JMenu    menu2;

    /** �˵���1,2,3,4,5*/
    private JMenuItem item1;
    private JMenuItem item2;
    private JMenuItem item3;
    private JMenuItem item4;
    private JMenuItem item5;
    
	public GameFrame(){		
		setTitle("ս����Ϸ");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(200, 0, 800, 625);
		menuInit();//�˵���ʼ��
		setVisible(true);
		loginPanel=new LoginPanel(this);
		addListener();
		setPanel(loginPanel);
	

	}
	
		
	 private void addListener(){
		 addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent e)
			 {
				 int closeCode=JOptionPane.showConfirmDialog(GameFrame.this, "�Ƿ��˳���Ϸ","��ʾ�� ",
						 JOptionPane.YES_NO_OPTION);
				 if(closeCode==JOptionPane.YES_OPTION) {
					 System.exit(0);
			 }
		 }
	 });
	 }

	
	 public void menuInit() {

		 	final GameFrame thisFrame=this;
			this.menubar = new JMenuBar();
			this.menu1 = new JMenu("�˵�");
	        this.menu2 = new JMenu("����");
	        this.item1 = new JMenuItem("���¿�ʼ");
	        this.item2 = new JMenuItem("�浵");
	        this.item3 = new JMenuItem("��ȡ�浵");
	        this.item4 = new JMenuItem("������ҳ��");
	        this.item5 = new JMenuItem("��Ϸ����");
			menu1.add(item1);
			menu1.addSeparator();
			menu1.add(item2);
			menu1.addSeparator();
			menu1.add(item3);
			menu1.addSeparator();
			menu1.add(item4);			
	        menu2.add(item5);
			menubar.add(menu1);
			menubar.add(menu2);
			setJMenuBar(menubar);
			item1.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent e)
	            {
	            	gamePanel=new GamePanel(thisFrame,false);
					thisFrame.setPanel(gamePanel);
	            }
	        }
	);
			item2.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						gamePanel.saveGame();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					 
				}
				
			}
		);
			item3.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent e)
	            {
					gamePanel=new GamePanel(thisFrame,true);
					thisFrame.setPanel(gamePanel);
	            }
	        }
	);
			item4.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent e)
	            {
	            	loginPanel=new LoginPanel(thisFrame);
					thisFrame.setPanel(loginPanel);
	            }
	        }
	);
			item5.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO �Զ����ɵķ������
					insPanel =new Instruction(thisFrame);
					thisFrame.setPanel(insPanel);	
				}
		}
	 );
	 }
	



	public void setPanel(JPanel panel)//�������
	 {
		 Container c=getContentPane();//��ʼ��һ������
		 c.removeAll();
		 c.add(panel);
		 c.validate();		
	 }
	 
	
	 
	public static void main(String[] args) {
		GameFrame myFrame=new GameFrame();

	}
}
