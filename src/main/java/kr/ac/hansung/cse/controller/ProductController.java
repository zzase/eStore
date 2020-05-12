package kr.ac.hansung.cse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.cse.model.Product;
import kr.ac.hansung.cse.service.ProductService;

@Controller
public class ProductController { // controller -> service -> dao
	@Autowired
	private ProductService productService;

	@RequestMapping("/products") // 이 url로 request가 오면 함수 실행
	public String getProducts(Model model) {
		List<Product> products = productService.getProducts();

		model.addAttribute("products", products);

		System.out.println(products);

		return "products"; // view's logical name(products.jsp)
	}

	@RequestMapping("/viewProduct/{productId}")
	public String viewProduct(@PathVariable int productId, Model model) {
		
		Product product = productService.getProductById(productId);

		model.addAttribute("product", product);

		return "viewProduct";
	}

}
