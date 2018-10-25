package com.example.stronka.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.stronka.model.Kot;

@Controller
public class IndexController {

	public final static List<Kot> KOTY = new ArrayList<>();

	@GetMapping
	public String index(Model model) {

		if (KOTY.isEmpty()) {
			Kot k1 = new Kot();
			k1.setNazwa("Kot 1");
			k1.setRasa("dachowiec");

			KOTY.add(k1);

			Kot k2 = new Kot();
			k2.setNazwa("Kot 2");
			k2.setRasa("rosyjski niebieski");

			KOTY.add(k2);
		}

		model.addAttribute("koty", KOTY);

		return "index";
	}
}
