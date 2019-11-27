package com.javatechie.spring.swagger.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.spring.swagger.api.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
