### Final mark:  /11

### Comments:

**Key:  'Y' - yes, 'N' - no, '~' - partial compliance**

### Criteria for gaining 4 / 11

* All of the required files are correct and have been committed and pushed.
 * admin/originality-G.md
 * admin/contribution-G.md
 * admin/best-uid.md
 * admin/G-features.md
 * All .java files
 * game.jar
 * presentation.pdf
* Authorship of each class needs to be clearly stated in a comment of each class. (Note: 'authorship details' is fairly open-ended. It may mean stating that the code was written by the group, or by one or two members, or that it was heavily adapted from some third party. Either way, it should be absolutely clear to the reader which person or persons were responsible for the code and the ideas behind it.).
* Git logs must indicate appropriate use of version control.
* The program must compile and run (from the .jar file).

### Criteria for gaining 6 / 11

*The previous criteria plus...*
* Your game must have at least pass-level functionality.
 * A working implementation of a basic _single-piece, single-player_ hex game implemented in JavaFX.
 * Executable on a standard lab computer from a runnable jar file, game.jar, which resides in the root level of your group repo.
 * Correctly implements `HexGame.toString()` that produces an encoding of the game represented by a `HexGame` object.
 * Generates a correct  game state when a `HexGame` object is created using the constructor that takes a game description.
* You have made appropriate use of object-oriented features such as inheritence and enum types.
* Your presentation pdf must have all required components.

### Criteria for gaining 7-8 / 11

*The previous criteria plus...*
* The program is well designed.
* Comments are clear and sufficient.
* Your game must have at least credit-level functionality.
 * The game a correct random game state when a `HexGame` object is created using its default constructor.
 * The game indicates a solvable objective to the user at the start of a round, and allows the user to input their solution via the mouse.
 * The game checks that users' solution is correct.
* Your coding style is good.
* You make good / appropriate use of JUnit tests throughout the project.

### Criteria for gaining 9-11 / 11

*The previous criteria plus...*
* Your design and code must be of very high quality.
* Your program demonstrates interesting extensions that go beyond the basic task.
* Your game must have at least distinction-level functionality.
 * The game provides a timer, limiting how long each round takes.
 * The game supports multiple players.
 * The game implements a scoring system.
 * The game identifies an optimal solution if the player's solution was not optimal.
* Your game works well and is easy for a new user to run.
* Your game has high-distinction-level functionality.
 * The game supports multiple pieces.
 * The game identifies the correctness of multi-piece moves.
 * The game identifies optimal multi-piece moves.
 * The game has a sense of level of difficulty, selecting moves accordingly (perhaps difficulty increases as the game progresses, or players can choose difficulty level; the details are left to you).
