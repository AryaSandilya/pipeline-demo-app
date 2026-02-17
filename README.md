# Pipeline Demo App

A simple Maven Java application for Jenkins Pipeline demonstration.

## Build
```bash
mvn clean package
```

## Run
```bash
java -jar target/pipeline-demo-app-1.0-SNAPSHOT.jar
```

## Test
```bash
mvn test
```

## Jenkins Pipeline

This project includes a Jenkinsfile for automated CI/CD pipeline.
```

### Step 9: Create .gitignore

1. Right-click on project root → **New** → **File**
2. Name: `.gitignore`
3. Add content:
```
# Maven
target/
pom.xml.tag
pom.xml.releaseBackup
pom.xml.versionsBackup
pom.xml.next
release.properties

# Eclipse
.classpath
.project
.settings/
bin/

# IntelliJ
.idea/
*.iml

# OS
.DS_Store
Thumbs.db

# Logs
*.log

# Package Files
*.jar
*.war
*.nar
*.ear
*.zip
*.tar.gz
*.rar
```

### Step 10: Update Maven Project

Right-click on project → **Maven** → **Update Project** → **OK**

### Step 11: Build and Test Locally

1. Right-click on project → **Run As** → **Maven build...**
2. Goals: `clean package`
3. Click **Run**

You should see in the Console:
```
BUILD SUCCESS
```

### Step 12: Run the Application

1. Right-click on project → **Run As** → **Maven build...**
2. Goals: `exec:java -Dexec.mainClass="com.example.app.App"`
3. Click **Run**

Or simply:
1. Right-click on `App.java` → **Run As** → **Java Application**

You should see output:
```
Hello from Jenkins Pipeline!
Build Date: 2026-02-12T...
Java Version: 17.0.x