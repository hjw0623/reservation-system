package hwj.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file")
public class FileUploadPageController {
	  @GetMapping
	    public String fileform(){
	        return "/fileuploadform";
	    }
}
