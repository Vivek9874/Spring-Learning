package com.learning.SpringBootEcom.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.learning.SpringBootEcom.Model.Product;
import com.learning.SpringBootEcom.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
		
	}

	public Optional<Product> getProductById(int id) {
		
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	public Product addOrUpdateProduct(Product product, MultipartFile imageFile) throws IOException {
		// TODO Auto-generated method stub
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageType(imageFile.getContentType());
		product.setImageData(imageFile.getBytes());
		
		return productRepository.save(product);
	}

	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

	public List<Product> searchProducts(String keyword) {
		// TODO Auto-generated method stub
		return productRepository.searchProducts(keyword);
	}

}
