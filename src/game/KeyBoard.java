/*플레이어의 움직임을 제어하자!!*/

package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoard extends KeyAdapter{
	Player player;
	
	//얻어오자 ->메서드 생각
	public KeyBoard(Player player) {
		this.player=player;
		
	}
	
	//키보드 누르면 움직임
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		
		switch(key){ //소괄호 안의 값에 대해 조건을 따져보겠다
		case KeyEvent.VK_LEFT:
			player.velX=-2; break; //끝이 없기 때문에 걸어줌
		case KeyEvent.VK_RIGHT:
			player.velX=2; break;
		case KeyEvent.VK_UP:
			player.velY=-2; break;
		case KeyEvent.VK_DOWN:
			player.velY=2; break;
		case KeyEvent.VK_SPACE:
			//총알생성
			player.fire();break;
		
		}
	}
	
	//키보드 떼면 움직임 멈춤
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		
		switch(key){ 
		case KeyEvent.VK_LEFT:
			player.velX=0; break; //끝이 없기 때문에 걸어줌
		case KeyEvent.VK_RIGHT:
			player.velX=0; break;
		case KeyEvent.VK_UP:
			player.velY=0; break;
		case KeyEvent.VK_DOWN:
			player.velY=0; break;
		
		
		}
	}
	
	
}
