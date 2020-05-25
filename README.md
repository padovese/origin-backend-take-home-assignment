# origin-backend-take-home-assignment
A solution for the assessment: https://github.com/OriginFinancial/origin-backend-take-home-assignment

## My opnion about the assessment
The challenge here is quite fun, it looks more like a real world problem than a super-crazy-academic-algorithm we face sometimes... it is extensive, although I made it all on the same day I started, I spent a considerable time on it.
Java and even Kotlin are more verbose than Python, maybe this is a point to consider. I liked to put attention on the details and tried to deliver the best experience for the ones who will evaluate this. So, enjoy!

### Why Kotlin?
I really have a strong background using Java and it should be the right choose as always, but as soon as I read the problem I realized Kotlin would be handy because it is less verbose. I have a little experience with Python to be honest, only developing some small Lambdas on AWS to solve regular problems.

## Running the application
- Code

You can evaluate the code from github, but I recommend you to download it and visualize on IntelliJ. If you have it, of course.

- Compiling

In order to compile it you need to have the Java Development Kit(JDK) 11 installed. Once you download the repository, you can compile it by running:
```
$ ./gradlew build
```

When it is finished, the runnable jar will be generated at: '/build/libs/assessment-0.0.1-SNAPSHOT.jar'

- Without compiling

To facilitate this step, I compiled the code and uploaded it as well. Just extract the app.tag.gz.

- Running

It is okay to not have the JDK, but now you have to have at least the JRE installed to run it:
```
$ java -jar assessment-0.0.1-SNAPSHOT.jar
```

It will start on port 8080.

## Testing it

- CURL or Postman
```
curl -X POST "http://localhost:8080/insurance-plan" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"age\": 35, \"dependents\": 2, \"income\": 0, \"marital_status\": \"married\", \"risk_questions\": [ 0, 1, 0 ], \"house\": { \"ownership_status\": \"owned\" }, \"vehicle\": { \"year\": 2018 }}"
```

- Swagger

A catalog sums up the developer experience:  
http://localhost:8080/swagger-ui.html