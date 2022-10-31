package com.learning.bootRestTest.model;

public enum Continent {

	Asia,
	Europe,
	Africa,
	NorthAmerica("North America"),
	SouthAmerica("South America"),
	Antarctica;
	
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
}
