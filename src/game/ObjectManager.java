/*
 * 우리가 제작중인 게임은 게임루프가 오직 1개만 존재하기 때문에 
 * while 내에서 게임에 등장할 모든 오브젝트의 tick, render를 호출해야 할 의무가 있다..
 * 하지만, 게임에 등장할 객체들이 너무나 여러 클래스에 걸쳐서 복잡하게 등장하기 때문에
 * 게임루프인 while문 내에서 모든 객체들의 레퍼런스를 접근하기란 쉽지 않다..
 * 해결책 :게임에 등장할 모든 객체들을 관리해주는 존재가 필요하다!!
 * */

package game;

import java.util.ArrayList;

public class ObjectManager {
	//데이터 베이스 역할을 할 존재..
	ArrayList<GameObject> list=new ArrayList<GameObject>();
	
	//객체 등록
	//모든 게임에 등장할 객체는 생성될때 아래의 메서드를 통해
	//데이터베이스에 등록된다!!
	
	public void addObject(GameObject obj){
		list.add(obj);
	}
}
