package eu.sig.training.ch04;

public class SavingsAccount {
    private static final float INTEREST_PERCENTAGE = 0.04f;
    private Money balance = new Money();
    private CheckingAccount registeredCounterAccount;

    public Transfer makeTransfer(String counterAccount, Money amount)
            throws BusinessException {
        validateAccount(counterAccount);
        return createTransfer(counterAccount, amount);
    }

    private void validateAccount(String counterAccount) throws BusinessException {
        new AccountValidator(counterAccount).validate();
    }

    private Transfer createTransfer(String counterAccount, Money amount) throws BusinessException {
        CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
        Transfer transfer = new Transfer(this, acct, amount);
        if (!transfer.getCounterAccount().equals(this.registeredCounterAccount)) {
            throw new BusinessException("Counter-account not registered!");
        }

        return transfer;
    }

    public void addInterest() {
        Money interest = balance.multiply(INTEREST_PERCENTAGE);
        if (interest.greaterThan(0)) {
            balance.add(interest);
        } else {
            balance.substract(interest);
        }
    }
}
