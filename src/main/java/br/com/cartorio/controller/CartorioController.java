package br.com.cartorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cartorio.entities.Cartorio;
import br.com.cartorio.services.CartorioService;

@Controller
public class CartorioController {

	@Autowired
	private CartorioService cartorioService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Cartorio> cartorios = cartorioService.listarCartorios();
		model.addAttribute("cartorios", cartorios);
		return "index";
	}

	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Cartorio cartorio = new Cartorio();
		model.addAttribute("cartorio", cartorio);
		return "new_cartorio";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("cartorio") Cartorio cartorio) {
		cartorioService.inserirCartorio(cartorio);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_cartorio");
		Cartorio cartorio = cartorioService.visualizarCartorio(id);
		mav.addObject("cartorio", cartorio);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteCartorio(@PathVariable(name = "id") Long id) {
		cartorioService.excluirCartorio(id);
		return "redirect:/";
	}
}
