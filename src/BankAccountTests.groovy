/**
 * Created by peterki on 19/07/2017.
 */
class BankAccountTests extends GroovyTestCase {

    private account

    def void setUp() {
        account = new BankAccount(10)
    }

    def void tearDown() {
        account = null
    }

    def void testCanDepositMoney() {
        account.deposit(5)
        assert 15 == account.balance
    }

    def void testCanWithdrawMoney() {
        account.withdraw(5)
        assert 5 == account.balance
    }

    def void testCanNotWithdrawMoreMoneyThanBalance() {
        shouldFail(InsufficientFundsException) {
            account.withdraw(15)
        }
    }

    def void testCanAccrueInterest() {
        account.accrueInterest()

        assert 11 == account.balance
    }

}
