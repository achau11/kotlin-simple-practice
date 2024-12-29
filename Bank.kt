class Bank {
    val startingStatement: String = """
        Welcome to your Banking app.
        What type of account would you like to create?
        1. Debit account.
        2. Credit account.
        3. Checking account.
        Choose an option (1, 2, 3)
    """
}

enum class AccountType {
    Checking, Debit, Credit
}

fun getAccount(choice: Int?): AccountType {
    return when (choice) {
       1 -> AccountType.Checking
       2 -> AccountType.Debit
       3 -> AccountType.Credit
        else -> throw Throwable("Invalid choice: $choice")
    }
}

fun main() {
    val bank: Bank = Bank()
    var userChoice: Int? = 0
    val choices = listOf(1, 2, 3)
    println(bank.startingStatement)

    while (userChoice !in choices) {
        println("Please make a choice.")
        userChoice = readlnOrNull()?.toInt()
    }

    val userAccount = getAccount(userChoice)
    println("You have created a $userAccount account")
}