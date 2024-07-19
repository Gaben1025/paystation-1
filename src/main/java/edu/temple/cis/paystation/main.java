package edu.temple.cis.paystation;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class main {

    
    /** 
     * @param args
     * @throws IllegalCoinException
     */
    //testing new sdk and git
    public static void main(String[] args) throws IllegalCoinException {
        int userChoice,adminChoice,dayChoice;
        boolean freeDay = false;
        PayStation PayStation = new PayStationImpl();
        Scanner userInput = new Scanner(System.in);

        //Rate strategy objects
        PayRate linearOneRate = new LinearOneRate();
        PayRate linearTwoRate = new LinearTwoRate();
        PayRate progressiveRate = new ProgressiveRate();

        //Alternating rate initializations
        AlternatingRate alternatingRate = new AlternatingRate();

        //while loop to keep prompting the user
        while (true) {
            //Prompt if it is not a free day
            if (freeDay == false) {
                System.out.println("Welcome to Pay Station what would you like to do:\n" +
                        "(1) Deposit Coins\n" +
                        "(2) Display Time Accumulated\n" +
                        "(3) Buy Ticket\n" +
                        "(4) Cancel\n" +
                        "(5) Admin Mode\n" +
                        "(0) Quit Pay Station");
                userChoice = Integer.valueOf(userInput.nextLine());
            }
            //Prompt if it is a free day
            else
            {
                //Sets freeDay back to false, for future use
                freeDay = false;
                /**
                 * While loop to make sure the user input entered is only 5 or 0
                 * since all other options are unecessary because of the free day
                 */
                while(true) {
                    System.out.println("Welcome to Pay Station what would you like to do:\n" +
                            "Today is a free day, enjoy!\n" +
                            "(5) Admin Mode\n" +
                            "(0) Quit Pay Station");
                    userChoice = Integer.valueOf(userInput.nextLine());
                    //Choice is not 5 or 0
                    if(userChoice != 5 && userChoice != 0)
                    { System.out.println("Please enter a valid choice"); }
                    //Choice is valid and while loop finishes, program continues
                    else { break;}
                }
            }

            //Nested switches for user and admin
            /**
             * First Switch
             * This switch is used for non-admin choices
             */
            switch (userChoice)
            {
                //Insert Coins
                case 1:
                    System.out.println("How much would you like to deposit (5/10/25):\n(-1 to stop deposit)");
                    while(true) {
                        userChoice = Integer.valueOf(userInput.nextLine());
                        System.out.println("Coin Entered");
                        if (userChoice != -1){
                            PayStation.addPayment(userChoice);
                        }
                        else{
                            break;
                        }
                    }
                    break;
                //Display
                case 2:
                    System.out.println(PayStation.readDisplay() + " minutes with current rate");
                    break;
                //Buy
                case 3:
                    System.out.println(PayStation.buy().value() + " minutes bought");
                    break;
                //Cancel
                case 4:
                    System.out.println(PayStation.cancel() + " coins returned");
                    break;
                //Admin
                case 5:
                    System.out.println("Admin Mode:\n" +
                            "(1) Empty\n" +
                            "CHANGE TO TOWN RATE:\n" +
                            "(2) Alphatown\n" +
                            "(3) Betatown\n" +
                            "(4) Deltatown\n" +
                            "(5) Gammatown\n" +
                            "(6) Omegatown\n" +
                            "(0) Quit Pay Station");
                    adminChoice = Integer.valueOf(userInput.nextLine());
                    /**
                     * Second Switch
                     * This switch is used for admin choices
                     */
                    switch (adminChoice)
                    {
                        //Empty
                        case 1:
                            System.out.println("¢" + PayStation.empty() + " collected");
                            break;
                        //Alpha
                        case 2:
                            PayStation.setPayRate(linearOneRate);
                            break;
                        //Beta
                        case 3:
                            PayStation.setPayRate(progressiveRate);
                            break;
                        //Delta
                        case 4:
                            PayStation.setPayRate(linearTwoRate);
                            break;
                        //Gamma
                        case 5:
                            System.out.println("ENTER THE DAY:\n" +
                                    "(1) Weekday\n" +
                                    "(2) Weekend");
                            dayChoice = Integer.valueOf(userInput.nextLine());


                            if(alternatingRate.calculateRate(adminChoice,dayChoice,PayStation) == 0) {
                                System.out.printf("ERROR");
                            }

                            break;
                        //Omega
                        case 6:
                            System.out.println("ENTER THE DAY:\n" +
                                    "(1) Weekday\n" +
                                    "(2) Weekend");
                            dayChoice = Integer.valueOf(userInput.nextLine());

                            if(alternatingRate.calculateRate(adminChoice,dayChoice,PayStation) == 0) { freeDay = true; }

                            break;
                        case 0:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("\nEnter a valid choice\n");
                            break;
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nEnter a valid choice\n");
                    break;
            }
        }
    }
}
