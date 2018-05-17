package simpleAPI.model;

import org.joda.time.LocalTime;

public class Greeting {

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	private final long id;
	private final String content;
	private String time;

	public String getTime() {
		return time;
	}

	public Greeting(long counter, String content, LocalTime time) {
		this.id = counter;
		this.content = content;
		this.time = time.toString();
	}

}
