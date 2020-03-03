package imports;
/*
 * @Author  Wrial
 * @Date Created in 22:17 2020/2/26
 * @Description
 */


public class MyIndexDao1 implements IndexDao {
	MyIndexDao1(){
		System.out.println("MyIndexDao1------init");
	}
	

	public void query(){
		System.out.println("MyIndexDao1");
	}

}
