import java.util.*;

public class Main{
    public static void main(String[] args) {
        ATMop obj = new ATMop();
    }
}
class Data{
    int balance;
    ArrayList<Integer> arrayList = new ArrayList<>();
}
class ATMop {
    HashMap<Integer , Data >  map  = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    ATMop(){
        System.out.println("Welcome to our ATM");
        opNew();
    }
    public void opEx() {
        System.out.println("Enter valid pin");

        int pin = sc.nextInt();

        if (map.containsKey(pin)) {
            Data obj = map.get(pin);
            menu(obj);
        }
        else {
            System.out.println("No A/C Exist");
            another();
        }
    }
        public void opNew(){
            System.out.println("Please Create an Account first ");
            System.out.println("set pin code");
            System.out.println("set pin greater than 2  and less than 5");

            int setpin = sc.nextInt();

            Data obj = new Data();
            if(Integer.toString(setpin).length() < 5 && 2<Integer.toString(setpin).length() ){
                obj.balance = 0;
                map.put(setpin , obj);
                menu(obj);
            }
            else{
                System.out.println("Invalid pin system terminate");
                opNew();
            }
        }


    public void menu(Data obj){
        System.out.println("*********************");
        System.out.println("Enter your choice");
        System.out.println("1 . Check Balance");
        System.out.println("2 . Withdraw Money");
        System.out.println("3 . Deposit Money");
        System.out.println("4 . Money Transfer");
        System.out.println("5 . Transaction History");
        System.out.println("6 . Exit");
        int x = sc.nextInt();
        System.out.println("*********************");
        if(x == 1){
            check_balance(obj);
        }
        else if(x==2){
            withdraw(obj);
        }
        else if(x==3){
            deposite(obj);
        } else if (x==4) {
            transfer(obj);
        } else if(x == 6){
            System.out.println("thank you for using our ATM");
            another();
        }else if(x == 5){
            System.out.println("Transaction History is :");
            transactHis(obj);
        }
        else{
            System.out.println("enter valid option");
            menu(obj);
        }
    }
    public void another(){
        System.out.println("1. Access another A/C");
        System.out.println("2. Create New A/C");
        System.out.println("3.Exit");
        System.out.println("Enter choice:");
        int ch = sc.nextInt();
        if (ch==1){
            opEx();
        }else if(ch == 3){
            System.out.println("exit");
        } else if (ch==2) {
            opNew();

        }
    }

    public void check_balance(Data obj){
        System.out.println("your current balance " + obj.balance);
        menu(obj);
    }

    public void deposite(Data obj){
        System.out.println("enter the amount ");
        int d = sc.nextInt();
        obj.balance += d;
        obj.arrayList.add(d);
        System.out.println("amount deposited successfully ");
        menu(obj);
    }

    public void withdraw(Data obj){
        System.out.println("enter the amount ");
        int d = sc.nextInt();
        if(d > obj.balance) {
            System.out.println("insufficient balance");
            menu(obj);
        }
        obj.balance -= d;
        obj.arrayList.add(-d);
        System.out.println("amount withdraw successfully ");
       // System.out.println("******************************************************************************");
        menu(obj);
    }
    public void  transfer(Data obj){
        System.out.println("1. Existing A/C:");
        System.out.println("2. Exit");
        System.out.println("Enter your Choice:");
        int ch = sc.nextInt();

        if (ch==1){
            System.out.println("Enter Pin Here:");
            int rePin = sc.nextInt();
            if (map.containsKey(rePin))
            {   Data obj2 = map.get(rePin);
                System.out.println("Enter your amount:");
                int tAmount = sc.nextInt();

                if (obj.balance>=tAmount){
                    obj2.balance += tAmount;
                    obj.balance = obj.balance - tAmount;
                    obj2.arrayList.add(tAmount);
                    obj.arrayList.add(-tAmount);


                    menu(obj);
                }
                else {
                    System.out.println("Insufficient Balance");
                    menu(obj);
                }
            }
            else {
                System.out.println("Wrong Pin");
                transfer(obj);
            }
        } else if (ch==2) {
            menu(obj);

        }
        else {
            System.out.println("Wrong Choice");
            transfer(obj);
        }

    }
        public void transactHis(Data obj){
            for (int num : obj.arrayList) {
                System.out.println(num);
            }
            menu(obj);

        }

}