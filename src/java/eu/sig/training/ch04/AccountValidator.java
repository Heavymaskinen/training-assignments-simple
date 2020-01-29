package eu.sig.training.ch04;

public class AccountValidator {
    private String counterAccount;

    public AccountValidator(String counterAccount) {
        this.counterAccount = counterAccount;
    }

    public void validate() throws BusinessException {
        int accountNumber = 0;
        for (int i = 0; i < counterAccount.length(); i++) {
            accountNumber = addCharValueToNumber(accountNumber, i);
        }

        if (!isValidAccountNumber(accountNumber)) {
            throw new BusinessException("Invalid account number!");
        }
    }

    private int addCharValueToNumber(int accountNumber, int i) {
        char character = counterAccount.charAt(i);
        int characterValue = Character.getNumericValue(character);
        accountNumber = accountNumber + (9 - i) * characterValue;
        return accountNumber;
    }

    private boolean isValidAccountNumber(int sum) {
        return sum % 11 == 0;
    }
}
