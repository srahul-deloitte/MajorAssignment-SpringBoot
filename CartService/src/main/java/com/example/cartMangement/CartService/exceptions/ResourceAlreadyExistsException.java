package com.example.cartMangement.CartService.exceptions;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResourceAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	
	
	public ResourceAlreadyExistsException(String msg) {
		super(msg);
	}
}