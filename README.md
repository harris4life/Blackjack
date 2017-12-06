# README #

When the app starts up, the home page is displayed with the title of the game and three buttons labelled: "Play Game", "How To Play", and "Reset Progress". The play game button takes you to another activity 
where you can place your bet for the upcoming game. This screen also displays the amount of money the player current has and a button to go back to the home screen if necessary. Once the player has set their 
bet, they can press the deal button to start the game. The player and the dealer are both dealt two random cards. The object of the game is to try and get your card total as close to 21 as possible without
going over. The player can choose to add a card to their hand by pressing the hit button. The hit button will add another random card to the player's hand(recyclerview). When the player is satsified with the 
sum of cards they have in their hand, they can press the stay button which passes the turn to the dealer. The dealer is programmed to stay if they have a card total of 17 or more. Once the dealer ahs finished, 
text appears on the bottom of the screen displaying the outcome of the game. There will also be a notification that pops up that will explain the outcome of the game. If the notification is pressed, the player 
will be taken back to the bet screen to place another bet and play again. 

After clicking the how to play button, the app opens another activity that displays a few paragraphs of text explaining how to play the game. This text was received from a text file on a web server that we
are using from another class. The player can simply go back to the home page by hitting the back button on their phone.

After clicking the reset progress button, the players total amount of money will be reset to the default value. This way, the player can continue to play the game and bet as much as they please without worrying
about the amount of money they have left.