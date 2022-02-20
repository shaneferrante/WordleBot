# WordleBot

Wordle bot created for the original Wordle site (pre-NYT).

Average guesses per word: 3.6

Maxinum guesses per word: 5

Separate Feature: 
WordFinder class used to find 3 words which combine to contain the 15 most common english letters. (Useful for human gameplay of quordle, octordle, or sedecordle)

Instructions for use:

the testPlayer() function runs the wordle bot on every word in the game to gather performance data.

the playOnce(String) function plays the game one time with the given 5 letter word. (Assumes this word is a valid wordle word NO PLURALS).

the findWords() function finds three words that contain the 15 mist common english letters. One example is "Acorn, Deity, Slump"
