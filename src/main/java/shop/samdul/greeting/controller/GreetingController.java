package shop.samdul.greeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.samdul.greeting.model.People;

import java.util.Stack;

@Controller
public class GreetingController {

	private Stack<People> nameStack = new Stack<>();
  
  @GetMapping("/greeting")	
  public String greeting(@RequestParam(name="name", required=false, defaultValue="HI") String name, Model model) {
		People p = new People();
		if (!nameStack.isEmpty()) {
			People pp = nameStack.peek();
			p.setNum(pp.getNum() + 1);
		} else {
				p.setNum(1);
		}
		p.setName(name);
		nameStack.push(p);
		model.addAttribute("nameStack", nameStack);
		
		return "greeting";
  }
}
