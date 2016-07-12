package queens8;

public class Clock {
	private long start;	
	private long stop;
	
	public Clock() {
		start = 0;
		stop = 0;
	}
	
	public long getStart() {
		return start;
	}
	
	public long getStop() {
		return stop;
	}
	
	public void setStart(long start) {
		this.start = start;
	}
	
	public void setStop(long stop) {
		this.stop = stop;
	}
	
	public void start() {
		setStart(System.currentTimeMillis());
	}
	
	public void stop() {
		setStop(System.currentTimeMillis());
	}
	
	private double elapsedTime() {
		return System.currentTimeMillis() - getStart();
	}
	
	public double getElapsedTime() {
		return elapsedTime();
	}
}
