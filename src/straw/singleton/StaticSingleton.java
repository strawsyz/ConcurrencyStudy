package straw.singleton;

public class StaticSingleton {
	private StaticSingleton(){
		System.out.println("Singleton is created");
	}
	private static class SingletonHolder{
		private static StaticSingleton instance = new StaticSingleton();
	}
	public static StaticSingleton getInstance(){
		return SingletonHolder.instance;
	}
}
