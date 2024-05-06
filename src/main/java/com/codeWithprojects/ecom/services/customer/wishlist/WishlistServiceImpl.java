package com.codeWithprojects.ecom.services.customer.wishlist;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.codeWithprojects.ecom.dto.WishlistDto;
import com.codeWithprojects.ecom.entity.Product;
import com.codeWithprojects.ecom.entity.User;
import com.codeWithprojects.ecom.entity.Wishlist;
import com.codeWithprojects.ecom.repository.ProductRepository;
import com.codeWithprojects.ecom.repository.UserRepository;
import com.codeWithprojects.ecom.repository.WishlistRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {

	private final UserRepository  userRepository;
	
	private final ProductRepository productRepository;
	
	private final WishlistRepository wishlistRepository;
													
	
	public WishlistDto addProductToWishlist(WishlistDto wishlistDto) {
		Optional<Product> optionalProduct = productRepository.findById(wishlistDto.getProductId());
		Optional<User> optionalUser = userRepository.findById(wishlistDto.getUserId());
		
		if(optionalProduct.isPresent() && optionalUser.isPresent()) {
			Wishlist wishlist = new Wishlist();
			wishlist.setProduct(optionalProduct.get());
			wishlist.setUser(optionalUser.get());
			
			return wishlistRepository.save(wishlist).getWishlistDto();
		}
		return null;
	}
	
	public List<WishlistDto> getWishlistByUserId(Long userId){
		return wishlistRepository.findAllByUserId(userId).stream().map(Wishlist::getWishlistDto).collect(Collectors.toList());
	}
}
