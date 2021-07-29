package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gowtham.demo.dao.OrderRepo;
import com.gowtham.demo.dao.ProductRepo;
import com.gowtham.demo.domain.Orders;
import com.gowtham.demo.domain.Product;

@RestController
@RequestMapping("/rest")
public class OrderController {

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private ProductRepo productRepo;

	@GetMapping("/product/list")   
	public Iterable<Product> getProducts() {
		return  productRepo.findAll();
	}

	@PostMapping("/order/create")
	public Orders createOrder(@RequestBody Orders order) {
		return orderRepo.save(order);
	}
	@PostMapping("/product/create")
	public Product createProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}

	@GetMapping("/order/list")
	public Iterable<Orders> getOrders() {
		return orderRepo.findAll();
	}
	
	@GetMapping("/product/get")
	public Optional<Product> getByProductId(@RequestParam("id") int  id) {
		return productRepo.findById(id);
	}
	
	@GetMapping("/user_order/get")
	public Optional<Orders> getByOrderId(@RequestParam("oid") int oid){
		return orderRepo.findById(oid); 
	}
	
	@GetMapping("/order/place")
	public String placeOrder(@RequestParam("product_id") Integer id, @RequestParam("quantity") Integer quantity) {
		String res = "code: 1 \n msg: Invalid";
		Product product = productRepo.findById(id).orElse(new Product());
		if(product.getId() == 0) {
			return res;
		}
		Orders orders = new Orders();
		orders.setQuantity(quantity);
		orders.setProduct(product);
		orderRepo.save(orders);
		res = "code: 0 \n msg: Success";
		return res;
	}
	
	@GetMapping("/order/update")
	public String updateOrder(@RequestParam("id") Integer id, @RequestParam("quantity") Integer quantity) {
		String res = "code: 1 \n msg: Invalid";
		Orders orders = orderRepo.findById(id).orElse(new Orders());
		if(orders.getOid() == 0)
			return res; 
		
		orders.setQuantity(quantity);
		orderRepo.save(orders);
		res = "code: 0 \n msg: Success";
		
		return res;
	}
}
