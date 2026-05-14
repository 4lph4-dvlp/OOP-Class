public class TrafficLight {
	enum TrafficLightColor {RED, GREEN, YELLOW};
	public static void main(String[] args) {
		for(TrafficLightColor c : TrafficLightColor.values()) {
			switch (c) {
					case GREEN : System.out.println("go!"); break;
					case YELLOW : System.out.println("slowdown"); break;
					case RED : System.out.println("stop"); break;
			}
		}
	}
}
