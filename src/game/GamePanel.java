/*모든 게임은 이 패널안에서 그려질 예정임!
 * 아무리 게임의 장면이 다양하더라도, 패널은 
 * 오직 1개만 사용된다!!
 * 그래픽 아이템 모두 공유
 * 모든 객체는 tick(나의 물리량 변화),render(그리기) 메서드 보유
 * 객체 지향의 장점: 각각 별도로 움직일 수 있는 자기만의 멤버변수를 따로 가질 수 있다 
 * 
 * 모든 오브젝트는 결국 이 패널에 그려져야 하므로, 이 패널의 paint()메서드의 인수로 전달되는
 * Graphics 객체를 게임에 등장할 모든 오브젝트를 전달받아야 한다*/
package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	public static final int WIDTH=400;
	public static final int HEIGHT=300;
	public static final int SCALE=2; //800:600도 같은 비율이므로 이런식으로 스캐일 상수 지정하기도 함 
	boolean flag=true; // 게임 가동 여부를 결정하는 변수
	Thread thread; //게임 운영 쓰레드 , runnable은 쓰레드 아니다! run메서드를 갖고있는 것뿐->즉 , 쓰레드 생성해야 함
	Player player;
	ObjectManager objectManager; //객체 명단 관리자
	
	
	public GamePanel() {
		thread=new Thread(this); //run을 갖고있는 타겟->나(this)
		thread.start(); //쓰레드의 심장 움직임!
		
		init();
		//크기 지정 ->전체 프레임에서 pack() 지정했으므로 패널 크기에 의존.
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
	}
	
	public void init(){
		//명단 관리자 생성
		objectManager=new ObjectManager();
		
		//주인공 등장시키기
		player=new Player(objectManager,ObjectId.player,100, 200, 50, 50);
		
		//감독에 주인공 등록
		objectManager.addObject(player); //1명 추가됨
		
		//적군 등장!!
		Random r=new Random();
		
		for(int i=0; i<10; i++){
			int y=r.nextInt((HEIGHT*SCALE-50)-(50)+1)+50;
			int x=r.nextInt((WIDTH*SCALE-500)-(50)+1)+50;
			
			Enemy enemy=new Enemy(objectManager, ObjectId.Enemy, x,y,30,30);
			objectManager.addObject(enemy);
		}
		
		//패널과 키보드 리스너 연결-키이벤트가 패널 전체를 상대로 이루어지기 때문
		this.addKeyListener(new KeyBoard(player));
		
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		for(int i=0; i<objectManager.list.size(); i++){
			GameObject obj=objectManager.list.get(i);
			obj.render(g);
		}
	}


	//내가 이미 누구의 자식일때 runnable을 쓴다. 
	public void run() {
		while(flag){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//오브젝트 매니저에 등록된 모든 객체를 대상으로 tick()을 호출해보자!!
			for(int i=0; i<objectManager.list.size(); i++){
				GameObject obj=objectManager.list.get(i);
				obj.tick();
			}
			
			//player.tick();
			repaint(); //paintComponenet를 간접호출
			//총알의 tick, render
			//적군의 tick, render
			//아이템의 tick, render
		}
		
	}
	
	
}
