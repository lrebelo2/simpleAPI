package simpleAPI.webcontrollers;

import java.util.concurrent.atomic.AtomicLong;

import org.joda.time.LocalTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import simpleAPI.model.Greeting;
import simpleAPI.util.Mappings;

@RestController
public class GreetingController {
	
	private final AtomicLong counter = new AtomicLong();
	private static final String template = "Hello %s!";


	@RequestMapping(value =Mappings.GREETING,method=RequestMethod.GET)
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name){
		
		return new Greeting(this.counter.incrementAndGet(),
				String.format(template,name),new LocalTime());
		
	}

}
