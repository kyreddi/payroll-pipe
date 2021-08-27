package com.org.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.constants.PermissionURLConstants;


@RestController
@RequestMapping("/api/products")
public class ProductController {

	
	@GetMapping("/viewAll")
	@PreAuthorize("hasPermission('"+PermissionURLConstants.PRODUCT_API_SERVICE+"','"+PermissionURLConstants.VIEW+"')")
	public String viewProduct(){
		return "view Product" ;
	}
	
	@PostMapping("/add")
	public String createProduct() {
		return "add Product" ;
	}
	
	@PutMapping("/edit")
	public void update() { // 100 // 200  // 10
		System.out.println("updated");
	}
	
	@DeleteMapping("/delete")
	public String deleteProduct() {
		
		return "Product Deleted" ;
	}
	
	
}
