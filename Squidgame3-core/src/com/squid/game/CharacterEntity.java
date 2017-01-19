package com.squid.game;

import squidpony.squidmath.Coord;

public class CharacterEntity {
private Coord Position;
private String Name;
public Coord getPosition()
{
	return Position;
}

public void setPosition(Coord pos)
{
	Position = pos;
}

public String getName()
{
	return Name;
}

public void setName(String name)
{
	Name = name;
}
}
