package model;
public class Supplier 
{
	protected int m_ID;
	protected String m_Name;
	protected int m_Quality; // 1-10
	protected int m_Availability; // 1-10
	
	public int GetID() 
	{
		return m_ID;
	}
	
	public void SetID(int id) 
	{
		this.m_ID = id;
	}

	public String GetName() 
	{
		return m_Name;
	}

	public void SetName(String name)
	{
		this.m_Name = name;
	}

	public int GetQuality() 
	{
		return m_Quality;
	}

	public void SetQuality(int quality) 
	{
		this.m_Quality = quality;
	}

	public int GetAvailability() 
	{
		return m_Availability;
	}

	public void SetAvailability(int availability) 
	{
		this.m_Availability = availability;
	}
}
