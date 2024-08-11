package multiplebrowserintance;

public class MultiLanuch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        for(int i=0;i<5;i++) {
        	MultiBrowserLaunch th = new MultiBrowserLaunch();
        	th.start();
        }
	}

}
