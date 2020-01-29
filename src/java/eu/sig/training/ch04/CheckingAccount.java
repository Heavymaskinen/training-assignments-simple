package eu.sig.training.ch04;

public class CheckingAccount extends AbstractAccount {
    private static final float INTEREST_PERCENTAGE = 0.01f;
    private Money balance = new Money();
    private int transferLimit = 100;

    public Transfer makeTransfer(String counterAccount, Money amount)
            throws BusinessException {
        validateWithdrawalLimit(amount);
        validateAccountNumber(counterAccount);
        return createTransfer(counterAccount, amount);
    }

    private Transfer createTransfer(String counterAccount, Money amount) {
        CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
        return new Transfer(this, acct, amount);
    }

    private void validateAccountNumber(String counterAccount) throws BusinessException {
        new AccountValidator(counterAccount).validate();
    }

    private void validateWithdrawalLimit(Money amount) throws BusinessException {
        if (amount.greaterThan(this.transferLimit)) {
            throw new BusinessException("Limit exceeded!");
        }
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
