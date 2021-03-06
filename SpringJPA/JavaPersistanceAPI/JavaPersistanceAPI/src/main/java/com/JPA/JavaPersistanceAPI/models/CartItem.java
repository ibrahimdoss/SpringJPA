package com.JPA.JavaPersistanceAPI.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String productCode;
	
	private Integer quantity;
	
	private BigDecimal unitPrice;
	
	@ManyToOne
	private Cart cart;
	
	//Birçok ürün bir sepete ait yani carta ait oldugu icin ManyToOne

}
