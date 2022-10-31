package com.learning.bootRestTest.model;

import java.util.Optional;
import java.util.stream.Stream;

public enum Continent {

	Asia("Asia"),
	Europe("Europe"),
	Africa("Africa"),
	NorthAmerica("North America"),
	SouthAmerica("South America"),
	Antarctica("Antarctica"),
	Unspecified("Unspecified");
	
	private String continentName;
	
	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}
	
	private Continent() {
		
	}
	
	private Continent(String continentName)
    {
        this.continentName = continentName;
    }
	
	public static Continent of(String name) {
		
		Optional<String> cName = Optional.ofNullable(name);
		
        return Stream.of(Continent.values())
          .filter(p -> p.getContinentName().equalsIgnoreCase(cName.orElse("Unspecified")))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}
