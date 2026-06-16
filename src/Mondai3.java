import java.util.Scanner;

/**
 * 口座クラス
 * 残高を管理する
 */
class Account {

    // 残高
    private int balance;

    /**
     * コンストラクタ
     */
    public Account(int balance) {
        this.balance = balance;
    }

    /**
     * 残高取得
     */
    public int getBalance() {
        return balance;
    }

    /**
     * 入金処理
     */
    public void deposit(int amount) {
        balance += amount;
    }

    /**
     * 出金処理
     */
    public boolean withdraw(int amount) {

        // 残高不足チェック
        if (amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }
}

/**
 * ATMクラス
 * ATMの機能を管理する
 */
class ATM {

    // 口座情報
    private Account account;

    /**
     * コンストラクタ
     */
    public ATM(Account account) {
        this.account = account;
    }

    /**
     * 残高照会
     */
    public void showBalance() {

        System.out.println(
                "現在の残高は "
                + account.getBalance()
                + " 円です。");
    }

    /**
     * 入金
     */
    public void deposit(int amount) {

        account.deposit(amount);

        System.out.println(
                amount
                + " 円入金しました。");
    }

    /**
     * 出金
     */
    public void withdraw(int amount) {

        boolean result =
                account.withdraw(amount);

        if (result) {

            System.out.println(
                    amount
                    + " 円出金しました。");

        } else {

            System.out.println(
                    "残高が不足しています。");
        }
    }
}

/**
 * メインクラス
 */
public class Mondai3 {

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        // 初期残高10000円
        Account account =
                new Account(10000);

        // ATM生成
        ATM atm =
                new ATM(account);

        while (true) {

            System.out.println();
            System.out.println("===== ATM =====");
            System.out.println("1. 残高照会");
            System.out.println("2. 入金");
            System.out.println("3. 出金");
            System.out.println("0. 終了");

            System.out.print("選択 > ");

            int menu =
                    scanner.nextInt();

            switch (menu) {

            case 1:

                // 残高照会
                atm.showBalance();
                break;

            case 2:

                // 入金
                System.out.print(
                        "入金額 > ");

                int depositAmount =
                        scanner.nextInt();

                atm.deposit(
                        depositAmount);

                break;

            case 3:

                // 出金
                System.out.print(
                        "出金額 > ");

                int withdrawAmount =
                        scanner.nextInt();

                atm.withdraw(
                        withdrawAmount);

                break;

            case 0:

                // 終了
                System.out.println(
                        "ATMを終了します。");

                scanner.close();
                return;

            default:

                System.out.println(
                        "正しい番号を入力してください。");
            }
        }
    }
}