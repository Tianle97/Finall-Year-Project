package ie.gmit.sw.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ie.gmit.sw.models.MongoProduct;
import ie.gmit.sw.productService.ProductService;


@RestController
public class ProductController {
	@Autowired
	@Qualifier("ProductServiceImp")
	private ProductService productService;
	
	@ResponseBody
	@GetMapping("/products")
	public List<MongoProduct> getAll(){
		return productService.showAll();
	}
	
	@ResponseBody
	@PostMapping("add-Product")
	public String addProduct(@RequestBody MongoProduct mp){
		return productService.addProduct(mp);
	}
}
