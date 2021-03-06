package com.JPA.JavaPersistanceAPI;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.JPA.JavaPersistanceAPI.models.Cart;
import com.JPA.JavaPersistanceAPI.models.CartItem;
import com.JPA.JavaPersistanceAPI.models.Channel;
import com.JPA.JavaPersistanceAPI.models.Passport;
import com.JPA.JavaPersistanceAPI.models.Person;
import com.JPA.JavaPersistanceAPI.models.Subscriber;
import com.JPA.JavaPersistanceAPI.repository.CartItemRepository;
import com.JPA.JavaPersistanceAPI.repository.CartRepository;
import com.JPA.JavaPersistanceAPI.repository.ChannelRepository;
import com.JPA.JavaPersistanceAPI.repository.PassportRepository;
import com.JPA.JavaPersistanceAPI.repository.PersonRepository;
import com.JPA.JavaPersistanceAPI.repository.SubscriberRepository;

@Component
public class CommandLineApp implements CommandLineRunner{
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PassportRepository passportRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private ChannelRepository channelRepository;
	
	@Autowired
	private SubscriberRepository subscriberRepository;

	@Override
	public void run(String... args) throws Exception {
		oneToOneExample();
	//	oneToManyExample();
//		manyToManyExample();
		deleteExample();
	}
	
	 private void deleteExample() {
	        this.cartRepository.deleteById(1);
	    } 
	
	private void manyToManyExample() {
		Channel channel1 = new Channel();
		channel1.setName("ch1");
		channel1.setUrl("url1");
		
		Channel channel2 = new Channel();
		channel2.setName("ch2");
		channel2.setUrl("url2");
		
		Subscriber subscriber1 = new Subscriber();
		subscriber1.setUsername("user1");
		Subscriber subscriber2 = new Subscriber();
		subscriber2.setUsername("user2");
		
		channel1.setSubscribers(List.of(subscriber1, subscriber2));
		this.subscriberRepository.saveAll(List.of(subscriber1, subscriber2));
		this.channelRepository.saveAll(List.of(channel1, channel2));
		
		List<Channel> channels = this.channelRepository.findAll();
	
		List<Subscriber> subscribers = this.subscriberRepository.findAll();

		System.out.println(channels);
		System.out.println(subscribers);
		
		
	}
	
	private void oneToManyExample() {
		Cart cart = new Cart();
		cart.setUserId(5);
		
		this.cartRepository.save(cart);
		
		CartItem cartItem1 = new CartItem();
		cartItem1.setCart(cart);
		cartItem1.setProductCode("code1");
		cartItem1.setQuantity(2);
		cartItem1.setUnitPrice(BigDecimal.valueOf(24.5));
		
		CartItem cartItem2 = new CartItem();
		cartItem2.setCart(cart);
		cartItem2.setProductCode("code2");
		cartItem2.setQuantity(4);
		cartItem2.setUnitPrice(BigDecimal.valueOf(122.2));
		
		this.cartItemRepository.save(cartItem1);
		this.cartItemRepository.save(cartItem2);
		
		List<Cart> carts= this.cartRepository.findAll();
		List<CartItem> cartItems=  this.cartItemRepository.findAll();
		
		System.out.println(carts.get(0).getCartItems());
		System.out.println(cartItems.get(0).getCart());
		
	}

	private void oneToOneExample() {
		
		Person person = Person.builder()
				.name("ibrahim")
				.surname("dos").build();
		
		Passport passport = Passport.builder()
				.expireDate(Instant.now().plus(10, ChronoUnit.YEARS).getEpochSecond())
				.person(person)
				.build();
		
		this.passportRepository.save(passport);
		System.out.println(passport);
	}
	
}
