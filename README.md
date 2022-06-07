# BCRYPT
- jBCrypt is a Java implementation of OpenBSD's Blowfish Password hashing code, as described in "http://www.openbsd.org/papers/bcrypt-paper.ps" by Niels Provos and David Mazieres.
- more info: [JBCRYPT - Website](https://www.mindrot.org/projects/jBCrypt/)
****
## Contributors:
****
- code referenced from Raul Zarate  ![gitHub](https://github.com/zaratr)
****
## Port Instructions 
1. Clone
2. Run ./gradlew run --<args>
3. The app will allow you to create an account and conitnues with website using jBCrypt!
****
## Resources
- [Application properties](lib/src/main/resources/application.properties)
- [JBCRYPT - Website](https://www.mindrot.org/projects/jBCrypt/)
- [seattle-code-java-401d14](https://github.com/codefellows/seattle-code-java-401d14)
****
### Feature Tasks - start a app
- Create a database.
- Create a table that models users with a username, id, and hashed password.
- Create a table that models posts with a postId, userId and text content.
- Create a table with a 1-to-many relationship between users and posts.
- Authenticate the site so only logged-in users can see posts.
- Use Bcrypt to hash all passwords stored on the site.

Time estimated spent: 2 hours
Actual time spent: 5 hours
****

# Bcrypt
