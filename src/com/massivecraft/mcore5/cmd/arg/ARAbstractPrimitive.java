package com.massivecraft.mcore5.cmd.arg;

import org.bukkit.command.CommandSender;

public abstract class ARAbstractPrimitive<T> implements ArgReader<T>
{
	public abstract String typename();
	public abstract T convert(String str) throws Exception;
	
	@Override
	public ArgResult<T> read(String str, CommandSender sender)
	{
		ArgResult<T> result = new ArgResult<T>();
		
		try
		{
			result.setResult(this.convert(str));
		}
		catch (Exception e)
		{
			result.getErrors().add("<b>Invalid "+this.typename()+" \"<h>"+str+"\"<b>.");
		}
		
		return result;
	}
}
