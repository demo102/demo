package com.example.stronka.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.stronka.model.Kot;

@Controller
@RequestMapping("/formularz")
public class FormularzController {

	@GetMapping
	public String showFormularz(Model model) {
		model.addAttribute("kot", new Kot());
		return "formularz";
	}
	
	@PostMapping
	public String formularz(Kot kot) {
		IndexController.KOTY.add(kot);
		return "redirect:/";
	}
}
