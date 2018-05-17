package simpleAPI.webcontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import simpleAPI.util.Mappings;

@RestController
public class CustomErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

	@RequestMapping(value=Mappings.ERROR)
	public String error() {
		return "If you are seeing this, you got an error! Congrats!  "
				+ "if if there isn't a typo on the URL, it's supposed to be "
				+ "<server>/greeting\n"
				+"plus the optional ?name=<yourname>";
	}

	public String getErrorPath() {
		
		return Mappings.ERROR;
	}
	
	
}
