# LPS-java-test

## Usage
The application needs two command line arguments and will not start without them
> "name email"

After running the application it is filled up with an example html.
The options in the main menu are
* "add"
* "remove"
* "exit"

### Exit
Exiting is currently the only way to print the resulting html as per the *"szerkesztés befejezése (megjelenítés)"* part of the assignment

### Add
Use "**back**" command to go back to the main menu
Invalid inputs will prompt again
You have the option to add 
* "h1", "p"
> Asks for a single line of text
* "a"
> Asks for a line of text then a link
* "table"
> Asks for table size in two separate lines (*limited to 4 to keep it simple*)
> 
> Fill up table cells from **left to right** then **top to bottom**
* "tr", "td"
> It is currently not possible to add these elements outside of adding a **table**
> The application will warn as such

### Remove
Use "**back**" command to go back to the main menu
Invalid inputs will prompt again
You have the option to remove all currently handled elements
The application will delete child elements as well
