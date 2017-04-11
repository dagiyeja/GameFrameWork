/*
 *자바에서 지원되는 객체 중, 상수만을 모아놓은 집합을 가리켜 enum 객체라 한자.
 *enum객체는 상수를 모아놓기 때문에 이 상수값들 사이에 index가 존재하며 배열처럼 사용
 *할 수도 있다
 * */
package game;

public enum ObjectId {
	player, Enemy, Block, Bullet, Item //이 자체로 상수. 인덱스가 달림. 단어 자체를 구분하는 id개념 데이터로 씀
	
}
