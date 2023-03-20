package homework_004;
import java.util.*;
class Account{
    int accountId;
    String ownerName;
    double balance;
    public int getId(){
        return accountId;
    }
    public double getBalance() {
        return balance;
    }
    @Override
    public String toString(){
        return "##############################"+"\n"+
                "Your account id is = "+accountId+"\n"+
                "Owner name is = "+ownerName+"\n"+
                "Your balance is = "+balance+"\n";
    }
}
public class HomeWork{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Account> accountList = new ArrayList<>();
        int option = 0;
        do{
            System.out.println("=============== Bank Account Information ===============");
            System.out.println("1. Add Account");
            System.out.println("2. Edit Account");
            System.out.println("3. Delete Account");
            System.out.println("4. Show account Information");
            System.out.println("5. Exit the Program!!!");
            System.out.print("Please choose your option from (1-5) = ");
            option  = input.nextInt();
            switch(option){
                case  1:
                    System.out.println("--------------- Add Account ---------------");
                    Account account = new Account();
                    System.out.print("Please enter your id = ");
                    account.accountId = input.nextInt();
                    System.out.print("Please enter your name = ");
                    input.nextLine();
                    account.ownerName = input.nextLine();
                    System.out.print("Please enter your balance = ");
                    account.balance = input.nextDouble();
                    accountList.add(account);
                    break;
                case 2 :
                    int updateId = 0;
                    boolean isUpdateIdExist = false;
                    System.out.println("--------------- Update Account ---------------");
                    System.out.print("Please enter your account id to update = ");
                    updateId = input.nextInt();
                    for(Account accounts : accountList){
                        isUpdateIdExist = true;
                        System.out.print("Please enter your account name to update = ");
                        input.nextLine();
                        accounts.ownerName = input.nextLine();
                        System.out.print("Please enter your account balance to update = ");
                        accounts.balance = input.nextDouble();
                        System.out.println("Congratulations, You have successfully to update your account information...!");
                    }
                    if(!isUpdateIdExist){
                        System.out.println(updateId+" doesn't exist into my system. Please check it again...!");
                    }
                    break;
                case 3 :
                    int deleteId = 0;
                    boolean isDeletedIdExist = false;
                    System.out.println("--------------- Delete Account ---------------");
                    System.out.print("Please enter your account id to delete = ");
                    deleteId = input.nextInt();
                    Iterator<Account> iterator = accountList.iterator();
                    while(iterator.hasNext()){
                        Account account1 = iterator.next();
                        if(account1.accountId == deleteId){
                            isDeletedIdExist = true;
                            iterator.remove();
                            System.out.println("Your account id is = "+deleteId+" have removed successfully...!");
                        }
                    }
                    if(!isDeletedIdExist){
                        System.out.println(+deleteId+" doesn't exist into my system. Please check it again...!");
                    }
                    break;
                case 4 :
                    int showOption = 0;
                    System.out.println("--------------- Show Account Information ---------------");
                    System.out.println("1. Show account by ascending order by id");
                    System.out.println("2. Show account by descending order by id");
                    System.out.println("3. Show account by descending order by balance");
                    System.out.print("==> Please choose your option from (1-3) = ");
                    showOption =  input.nextInt();
                    switch(showOption){
                        case 1:
                            System.out.println("_______________ Show Account by Ascending Order (by id) _______________");
                            Collections.sort(accountList, Comparator.comparingInt(account1 -> account1.accountId));
                            for(Account acc : accountList){
                                System.out.println(acc);
                            }
                            break;
                        case 2:
                            System.out.println("_______________ Show Account by descending Order (by id) _______________");
                            Collections.sort(accountList, Comparator.comparingInt(Account::getId).reversed());
                            for(Account acc : accountList){
                                System.out.println(acc);
                            }
                            break;
                        case 3:
                            System.out.println("_______________ Show Account by descending Order (by balance) _______________");
                            Collections.sort(accountList,Comparator.comparingDouble(Account::getBalance).reversed());
                            for(Account acc : accountList){
                                System.out.println(acc);
                            }
                            break;
                    }
                    break;
                case 5 :
                    System.out.println("Exiting the program...!");
                    break;
                default:
                    System.out.println("Wrong Option!!! Please choose again from (1-5).");
            }
        }while(option  != 5);
    }
}
