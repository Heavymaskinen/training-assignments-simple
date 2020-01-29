package eu.sig.training.ch04;

public abstract class AbstractAccount {
    protected Money balance = new Money();

    protected void validateAccount(String counterAccount) throws BusinessException {
        new AccountValidator(counterAccount).validate();
    }

    public abstract void addInterest();
}
