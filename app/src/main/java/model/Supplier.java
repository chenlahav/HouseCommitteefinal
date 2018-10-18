package model;
public class Supplier 
{
	protected int m_ID;
	protected String m_Name;
	protected int m_Quality; // 1-10
	protected int m_Availability; // 1-10
	protected String m_Phone;
	protected String m_Price;
	protected String m_Category;

	public String GetPhone(){return m_Phone;}

	public void SetPhone(String phone){m_Phone = phone;}

	public String GetPrice(){return m_Price;}

	public void SetPrice(String price){m_Price = price;}

	public String GetCategory(){return m_Category;}

	public void SetCategory(String category){m_Category= category;}
	
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
