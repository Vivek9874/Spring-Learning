package com.learning.SpringBootEcom.Controllers;

import 	com.learning.SpringBootEcom.Model.Product;
import com.learning.SpringBootEcom.Service.ProductService;

import java.io.IOException;
import java.security.Provider.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("hello")
	public String hello() {
		return "This works?";
	}
	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts(){
		return new ResponseEntity(productService.getAllProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id){
		Optional<Product> product = productService.getProductById(id);
		
		if(product.isPresent()) {
			return new ResponseEntity<>(product.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
		
		Product savedproduct;
		try {
			savedproduct = productService.addOrUpdateProduct(product, imageFile);
			return new ResponseEntity<>(savedproduct, HttpStatus.CREATED);
		} catch (IOException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("product/{productId}/image")
	public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId) {
	    Optional<Product> productOptional = productService.getProductById(productId);

	    if (productOptional.isPresent()) {
	        Product product = productOptional.get();
	        return new ResponseEntity<>(product.getImageData(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile ){
		Product updatedProduct;
		try {
			updatedProduct = productService.addOrUpdateProduct(product, imageFile);
			return new ResponseEntity<>("Updated", HttpStatus.CREATED);
		} catch (IOException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		Optional<Product> deleteProduct = productService.getProductById(id);
		if(deleteProduct.isPresent()) {
			productService.deleteProduct(id);
			return new ResponseEntity<>("Deleted", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/product/keyword")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
		List<Product> products = productService.searchProducts(keyword);
		System.out.println("searchin with: "+keyword);
		return new ResponseEntity<>(products, HttpStatus.OK); 
		
	}
	
}


