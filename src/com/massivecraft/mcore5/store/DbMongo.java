package com.massivecraft.mcore5.store;

import com.massivecraft.mcore5.xlib.mongodb.BasicDBObject;
import com.massivecraft.mcore5.xlib.mongodb.DB;

public class DbMongo extends DbAbstract<BasicDBObject>
{
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //

	public DB db;
	
	protected DriverMongo driver;
	@Override public DriverMongo getDriver() { return driver; }
	
	// -------------------------------------------- //
	// CONSTRUCTORS
	// -------------------------------------------- //
	
	public DbMongo(DriverMongo driver, DB db)
	{
		this.driver = driver;
		this.db = db;
	}
	
	// -------------------------------------------- //
	// IMPLEMENTATION
	// -------------------------------------------- //

	@Override
	public String getName()
	{
		return db.getName();
	}
	
	@Override
	public boolean drop()
	{
		try
		{
			this.db.dropDatabase();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	@Override
	public Object getCollDriverObject(Coll<?, ?> coll)
	{
		return db.getCollection(coll.getName());
	}
}
