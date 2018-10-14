package model;
public class Payment
{
	private float m_Amount;
	private eMonths m_Month;
	
	public Payment(float amount, eMonths month)
	{
		m_Amount = amount;
		m_Month = month;
	}
	
	public String toString()
	{
		return m_Month.name() + ": " + m_Amount;
	}
}
