package com.learning.bootRestTest.model;

import java.util.Optional;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@AllArgsConstructor
public enum Continent {

	Asia("Asia"),
	Europe("Europe"),
	Africa("Africa"),
	NorthAmerica("North America"),
	SouthAmerica("South America"),
	Antarctica("Antarctica"),
	Unspecified("Unspecified");
	
	@Getter @Setter
	private String continentName;
	
	public static Continent of(String name) {
		
		Optional<String> cName = Optional.ofNullable(name);
		
        return Stream.of(Continent.values())
          .filter(p -> p.getContinentName().equalsIgnoreCase(cName.orElse("Unspecified")))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}
