package com.javatechie.spring.swagger.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javatechie.spring.swagger.api.dao.ItemRepository;
import com.javatechie.spring.swagger.api.model.Item;



@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;
	
	
	public String createItem(Item item) {
		itemRepository.save(item);
		return "item saved with id " + item.getItemID();
	}
	
	
	public Optional<Item> getItemByID(int itemID) {
	       return itemRepository.findById(itemID);
		}
	
	
	public void removeItem(int itemID) {
		itemRepository.deleteById(itemID);
			
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void depositItems(int amount) {
//		if(amount>0) {
//			itemRepository.findById(quantityInStock);
//			entityManager.merge(item.getQuantityInStock()+amount);
//		}else {
//			System.out.println("Illegal action!!!");
//		}
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void withrawItems(int amount) {
//		if(item.getQuantityInStock()==0) {
//			System.out.println("The stock is empty from items");
//		}
//		if(item.getQuantityInStock()<amount) {
//			System.out.println("Can't withdraw an amount that is bigger than the quantity in the stock");
//		}else {
//			entityManager.merge(item.getQuantityInStock()-amount);
//		}
	}
	}
