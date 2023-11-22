<h1 align="center">🧑‍💻Project13-Data_Organizer</h1>
<h3 align="center">website that recieves and saves member info into server</h3>

<h4>🛠️Tech stack</h4>

|field|Language and Tools|
|-----|-----|
|Front-end|<img src="https://img.shields.io/badge/-HTML5-F05032?style=for-the-badge&logo=html5&logoColor=ffffff">|
|Back-end|<img src="https://github.com/YaegunKim/YaegunKim/assets/117888155/ccd0369e-f186-48e8-82b2-e336a3184bc8" width="58" height="25"><img src="https://img.shields.io/badge/spring-green?style=for-the-badge&logo=spring">|
|Data Management|![Static Badge](https://img.shields.io/badge/mySQL-FFB22B?style=for-the-badge&logo=mysql)|

<br>

- For data accessing, I've tried using H2 Database and connected it with using JDBC.


<br>
<h3>Concerns/Challenges Notes</h3>

|Date|Nov.20.2023(Mon)|
|-----|-----|
|Situation|Today marked my first attempt at connecting to an H2 database using JDBC. On the homepage, there's a "memberlist" button that redirects to a page displaying a list of members. Upon a successful database connection, this page should show all members (currently, Yaegun, spring, and spring1 are in the database).|
|Problem|Although Spring runs without issues, the member list fails to display, and I continuously receive a "no mapping found" error. The terminal displayed the error message: "Wrong user name or password".|
|Solution|After researching the "Wrong user name or password" error in Spring Boot, common suggestions were to check the JDBC and H2 dependencies in the "build.gradle" file and to verify the H2 driver configuration in "application.properties". But unfortunately, these checks did not resolve the issue. However, realizing that the error belongs to H2 database credentials, I explored the possibility of specifying my H2 username. Eventually, I found that adding "spring.datasource.username=sa" to my "application.properties" (as 'sa' was my username) resolved the issue. As a result, the page successfully displayed the member list.|

|Date|Nov.22.2023(Wed)|
|-----|-----|
|Situation|I had completed implementing some test cases and wanted to commit these changes to my Git repository.|
|Problem|When attempting to push my changes, Git repeatedly failed, displaying the message: "the tip of your current branch is behind its remote counterpart." This indicated that my local branch was out of sync with the remote repository.|
|Temporary Solution|To resolve this, I first fetched the latest changes from the remote repository using git fetch. Then, I merged these changes into my main branch. After successfully merging and resolving any conflicts, I performed a force push with git push -f origin main, successfully updating the remote repository with my latest changes.|
|Real Solution|After implementing the temporary solution, I noticed that all changes I had made to the README file directly on the GitHub page were lost. I initially thought this was due to pushing the latest fetched changes, so I manually updated the README again after force push. However, the issue recurred upon pushing another change. I then realized that the cause of this problem was the absence of the README commit (made on GitHub) in my local branch. To rectify this, I replicated the README file changes locally and then pushed these changes, ensuring that the remote repository remained consistent with my local repository.|
