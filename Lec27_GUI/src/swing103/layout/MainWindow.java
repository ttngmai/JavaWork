package swing103.layout;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

/* 레이아웃 (layout)
 	
 	컨테이너마다 LayoutManager 가 존재.
 	: add 되는 컴포넌트의 '위치'와 '크기' 결정하고 '배치'함.
 	
 	컨테이너의 크기가 변하면 내부 컴포넌트들의 위치와 크기를 모두 재조정, 재배치
 	
 	LayoutManager (I)
	 	└─FlowLayout  :  왼쪽에서 오른쪽으로, 위에서 아래로 배치
	 	└─BorderLayout : 
	 	└─GridLayout
	 	└─CardLayout

 	
 	컨테이너의 디폴트 LayoutManager
 	AWT , Swing        │    디폴트 LayoutManager   
 	───────────────────┴───────────────────────────
 	Window, JWindow         BorderLayout
 	Frame, JFrame			BorderLayout
 	Dialog, JDialog			BorderLayout
 	Panel, JPanel			FlowLayout
 	Applet, JApplet			FlowLayout
 	
 	
 	컨테이너의 layout manager 설정 --> setLayout()
 	
 	
 */

public class MainWindow {
	public static void main(String[] args) {
		
		new NullContainerFrame();
		
	} // end main()
} // end class

class NullContainerFrame extends JFrame {
	public NullContainerFrame() {
		setTitle("NullContainer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);   // 컨테이너의 LayoutManager 제거
		
		// label 컴포넌트
		JLabel lbl = new JLabel("Hello, Press Buttons");
		lbl.setLocation(130, 50);  // 컴포넌트의 위치 지정 가능!
		lbl.setSize(200, 20); // 크기 지정
		
		c.add(lbl);
		
		
		setLocation(150, 150);
		setSize(400, 200);
		setVisible(true);
	}
}











