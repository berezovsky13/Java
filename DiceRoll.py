# -*- coding: utf-8 -*-
import random
def func():
    dice = random.randint(1, 6)
    return dice




def main():
    player1 = 0
    player2 = 0
    rounds = 1
    while(rounds!=4):
        print(" Rounds " + str(rounds))
        player1 = func()
        player2 = func()
        print("Player 1 Roll " + str(player1))
        print("Player 2 Roll " + str(player2))

        if(player1==player2):
            print("Draw")
        elif(player1>player2):
            print("player 1 is the winner !!!")
        elif(player2>player1):
            print("player 2 is the winner !!!")

        rounds = rounds +1


   
    pass  # Replace Pass with Your Code


if __name__ == '__main__':
    main()
