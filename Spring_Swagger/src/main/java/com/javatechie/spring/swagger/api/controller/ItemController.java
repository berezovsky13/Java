package com.javatechie.spring.swagger.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.swagger.api.model.Item;
import com.javatechie.spring.swagger.api.service.ItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/item")
@Api(value = "Item Service", description = "Inventory of items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@PostMapping("/save")
	@ApiOperation(value = "create item in the inventory")
	public String saveBook(@RequestBody Item item) {
		return itemService.createItem(item);
	}

	@ApiOperation(value = "search for item by ID")
	@GetMapping("/searchItem/{itemID}")
	public Optional<Item> getItemByID(int itemID) {
	       return itemService.getItemByID(itemID);
		}

	@DeleteMapping("/deleteItem/{itemID}")
	public void deleteItem(@PathVariable int itemID) {
		itemService.removeItem(itemID);
	}
	
	@PutMapping("/deposit")
	public void depositItems(int amount) {
    }
	
	
	@PutMapping("/withraw")
	public void withrawItems(int amount) {
		
	}
}
