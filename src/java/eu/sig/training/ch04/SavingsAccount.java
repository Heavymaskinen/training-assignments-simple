package eu.sig.training.ch04;

public class SavingsAccount extends AbstractAccount {
    private CheckingAccount registeredCounterAccount;

    protected SavingsAccount() {
        super(0.04f);
    }

    public Transfer makeTransfer(String counterAccount, Money amount)
            throws BusinessException {
        validateAccount(counterAccount);
        return createTransfer(counterAccount, amount);
    }

    private Transfer createTransfer(String counterAccount, Money amount) throws BusinessException {
        CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
        Transfer transfer = new Transfer(this, acct, amount);
        if (!transfer.getCounterAccount().equals(this.registeredCounterAccount)) {
            throw new BusinessException("Counter-account not registered!");
        }

        return transfer;
    }

}
