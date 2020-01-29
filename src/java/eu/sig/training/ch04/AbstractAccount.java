package eu.sig.training.ch04;

public abstract class AbstractAccount {
    protected Money balance = new Money();
    private float interestPercentage;

    protected AbstractAccount(float interestPercentage) {
        this.interestPercentage = interestPercentage;
    }

    protected void validateAccount(String counterAccount) throws BusinessException {
        new AccountValidator(counterAccount).validate();
    }

    public void addInterest() {
        Money interest = balance.multiply(interestPercentage);
        if (interest.greaterThan(0)) {
            balance.add(interest);
        } else {
            balance.substract(interest);
        }
    }
}
