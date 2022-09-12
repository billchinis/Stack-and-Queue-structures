# Stack
StringStackImpl.java implements the interface `StringStack.java` and there is a simple application in `TagMatching.java`. Where the implemented stack is used to check if an html file with basic tags (e.g. body, h1, center, ol, li) is correct, for example, if somewhere there is the tag `<center>`, later on the file there must be the tag `</center>`, which signals the end of the center alignment. Even though many browsers exhibit tolerance in the existence of such non paired tags, we don't won't to have these kind of tags in the files we process.

# Files
* StringStack.java: stack interface.
* -StringStackImpl.java: stack implementation.
* -ListNode.java: Singly linked list implementation.
* -TagMatching.java: Main program that uses all the above to check if an html is correct.
* -example.html: Correct html example.

# HowTo
Open cmd in the same folder as the files and run the commands below.

`javac TagMatching.java`

`java TagMatching example.html`
