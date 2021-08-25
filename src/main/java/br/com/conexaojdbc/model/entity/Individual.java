package br.com.conexaojdbc.model.entity;

public class Individual extends TaxPayer {

    private Double healthExpenditures;

    public Individual() {
        super();
    }

    public Individual(String name, Double annualIncome, Double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        if (healthExpenditures > 0) {
            if (annualIncome < 2000.00) {
                return (annualIncome * 0.15) - (healthExpenditures * 0.5);
            } else {
                return (annualIncome * 0.25) - (healthExpenditures * 0.5);
            }
        } else {
            if (annualIncome < 2000.00) {
                return (annualIncome * 0.15);
            } else {
                return (annualIncome * 0.25);
            }
        }
    }
}
