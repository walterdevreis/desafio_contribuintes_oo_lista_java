package entities;

public class TaxPayer {
	
	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;
	
	//Construtores
	public TaxPayer() {
	}

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	//Getters and Setters
	public double getSalaryIncome() {
		return salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}	

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}
	
	//Operations
	public double salaryTax() {
		if(getSalaryIncome() / 12 > 5000.00) {
			return getSalaryIncome() / 100 * 20;
		} 
		else if (getSalaryIncome() / 12 > 3000.00 && getSalaryIncome() / 12 < 5000.00) {
			return getSalaryIncome() / 100 * 10;
		}
		else {
			return 0.00;
		}
	}
	
	public double servicesTax() {
		return getServicesIncome() * 0.15;
	}
	
	public double capitalTax() {
		return getCapitalIncome() * 0.2;
	}
	
	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}
	
	public double taxRebate() {
		double mDedutivel = grossTax() * 0.3;
		double gDedutivel = getHealthSpending() + getEducationSpending();
		if(mDedutivel < gDedutivel) {
			return mDedutivel;
		}
		else {
			return gDedutivel;
		}
	}
	
	public double netTax() {
		return grossTax() - taxRebate();				
	}
	
	public String toString() {
		return "Imposto bruto total: "
				+ String.format("%.2f%n", grossTax())
				+ "Abatimento: "
				+ String.format("%.2f%n", taxRebate())
				+ "Imposto devido: "
				+ String.format("%.2f%n", netTax());
	}
}
