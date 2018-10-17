package model;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Resident extends User
{
	protected Integer m_ApartmentNumber;
	protected eRole m_Role;
	protected int m_MonthlyPayment;
	protected ArrayList<Payment> m_PaidPayments = new ArrayList<>();

	public Resident() {}

	public Resident(String i_FirstName, String i_LastName, String i_ID, int i_ApartmentNumber, int i_MonthlyPayment)
	{
		super(i_FirstName, i_LastName, i_ID);
		SetApartmentNumber(i_ApartmentNumber);
		SetMonthlyPayment(i_MonthlyPayment);
		m_Role = eRole.Resident;
		initPayments();
	}

	public void initPayments(){
		for(int i=1; i<=12; i++){
			m_PaidPayments.add(new Payment(0, i));
		}
	}

	public eRole GetRole()
	{
		return m_Role;
	}

	public void SetMonthlyPayment(int i_MonthlyPayment)
	{
		m_MonthlyPayment = i_MonthlyPayment;
	}
	
	public void SetPayments(ArrayList<Payment> payments)
	{
		m_PaidPayments = payments;
	}
	
	public ArrayList<Payment> GetPayments()
	{
		return m_PaidPayments;
	}
	
	public int GetApartmentNumber()
	{
		return m_ApartmentNumber.intValue();
	}

	public int GetMounhtlyPayment() { return m_MonthlyPayment; }
	
	public void SetApartmentNumber(int i_AptNumber)
	{
		if(!isValidApartment(i_AptNumber))
		{
			throw new InvalidParameterException("Inavlid apartment number.");
		}
		
		m_ApartmentNumber = new Integer(i_AptNumber);
	}
	
	public String toString()
	{
		return super.toString() + "#APT: " + m_ApartmentNumber.intValue();
	}

	private boolean isValidApartment(int i_AptToCheck)
	{
		return (i_AptToCheck > 0);
	}
}
