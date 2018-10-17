package model;

import java.io.Serializable;

public class Payment implements Serializable
{
	protected int m_Amount;
	protected int m_Month;

	public int getM_Amount() {
		return m_Amount;
	}

	public void setM_Amount(int m_Amount) {
		this.m_Amount = m_Amount;
	}

	public int getM_Month() {
		return m_Month;
	}

	public void setM_Month(int m_Month) {
		this.m_Month = m_Month;
	}

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
