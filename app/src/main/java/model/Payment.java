package model;

import java.io.Serializable;

public class Payment implements Serializable
{
	protected int m_Amount;
	protected int m_Month;

	public Payment() {}

	public Payment(int amount, int month)
	{
		m_Amount = amount;
		m_Month = month;
	}
	
	public String toString()
	{
		return m_Month + ": " + m_Amount;
	}
}
