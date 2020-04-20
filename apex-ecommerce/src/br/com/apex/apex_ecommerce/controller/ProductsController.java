package br.com.apex.apex_ecommerce.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.apex.apex_ecommerce.dao.ProductDAO;
import br.com.apex.apex_ecommerce.model.BookType;
import br.com.apex.apex_ecommerce.model.Product;

@Controller
@Transactional
public class ProductsController {

	@Autowired
	private ProductDAO productDAO;

//1 passo apos cria o jsp mapear ele aqui 
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("/products/list");

		modelAndView.addObject("products", productDAO.list());

		return modelAndView;
	}

	@RequestMapping(value = "/produtos", method = RequestMethod.POST)
	public ModelAndView save(Product product, RedirectAttributes redirectAttributes) {

		ModelAndView modelAndView = new ModelAndView("redirect:produtos");

		productDAO.save(product);
		System.out.println("Cadastrando o produto " + product);

		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso !");

		return modelAndView;
	}

	@RequestMapping("/produtos/form")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("products/form");
		modelAndView.addObject("types", BookType.values());
		return modelAndView;
	}
}
