Here are the Copilot Prompts used for this assignment:

Prompt 1: I want you do to the following: Create the following classes:

Video (Abstract Class)
Fields: title, genre, available (private, with getters/setters).
Constructor to set title and genre.
Abstract method: play().
Method rentVideo() → marks as unavailable.
Method returnVideo() → marks as available.

Movie (Subclass of Video)
Implements play() with a custom message.
Overloaded method: play(String quality) (HD, 4K, etc.).

Series (Subclass of Video)
Implements play() differently (e.g., print "Playing episode of series").

GoldenVideoStoreApp (Main Class)
Create an array of Video objects (mix of Movie and Series).
Demonstrate:
Adding videos to the array.
Looping through and calling play() on each (shows polymorphism).
Renting and returning a video (shows encapsulation).
Using the overloaded play() method.
Print a list of available videos using an array traversal.

End Goal
Should expect something like this printed in the log:
Playing movie: Inception
Playing movie in HD quality.
Playing series: Stranger Things
Renting Inception...
Available: false
Returning Inception...
Available: true
Available Videos: Stranger Things

Prompt 2: Great! Now push these changes to my github repor GoldenVideoStore
