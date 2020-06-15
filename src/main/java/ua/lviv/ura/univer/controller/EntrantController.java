package ua.lviv.ura.univer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.ura.univer.domain.Entrant;
import ua.lviv.ura.univer.service.EntrantService;


@Controller
public class EntrantController {
	
	@Autowired
	EntrantService entrantService;
	
	@RequestMapping(value = "/addEntrant", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("entrant", new Entrant());
		
		return "addEntrant";
	}
	
	 @RequestMapping(value ="/addEntrant", method = RequestMethod.POST)
	 public String createEntrant(@ModelAttribute("entrant") Entrant entrant, BindingResult bindingResult, Model model) {
		 if (bindingResult.hasErrors()) {
	            return "addEntrant";
	        }
	     entrantService.save(entrant);


	        return "redirect:/home";
	    }
	
	   @RequestMapping(value ="/home", method = RequestMethod.GET)
	    public ModelAndView welcome() {
	    	ModelAndView map = new ModelAndView("home");
			map.addObject("entrants", entrantService.getAllEntants());
			
	    	return map;
	    }
	    
	   
}
