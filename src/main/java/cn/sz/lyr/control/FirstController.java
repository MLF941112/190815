package cn.sz.lyr.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FirstController {
	@RequestMapping(value="/")
	public String showfirstpage(){
		
		return "redirect:/bc/findall";
	}
}
