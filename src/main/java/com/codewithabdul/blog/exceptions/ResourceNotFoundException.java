package com.codewithabdul.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
	
	String resourceName;
	String fieldName;
	long fieldValue;
	
	
	public ResourceNotFoundException(String  resourceName, String fieldName,long fieldValue) {
		
		super(String.format("%s This id is not persent in this Aap %s : %s",resourceName,fieldName,fieldValue));
		
		this.resourceName=resourceName;
		this.fieldName=fieldName;
		this.fieldValue=fieldValue;
		
	}

}
