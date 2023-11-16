package com.codewithabdul.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class CategoryDto {

	private Integer categoryidInteger;
	
	@NotEmpty
	@Size(min = 4, max = 10,message=(" must be minimum 3 and Maximum 10 charectar"))
	private String categoryTitle;
	
	@NotEmpty
	private String categoryDescription;
	
}
