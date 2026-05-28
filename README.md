# Javaweb-boot-mybatis

## Tech Stack
### Spring Boot Version: 3.5.14
### Starters and Dependencies:
- Developer Tools: Lombok
- Web: Spring Web
- SQL: MyBatis Framework, MySQL Driver

## Project Introduction
A Spring Boot 4.0 + MyBatis user management and file upload system.
 
## Project Structure

```text
javaweb-boot-03-mybatis
├── .idea/
├── .mvn/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/woxueit/boot/
│       │       ├── config/
│       │       │   └── WebConfig.java
│       │       ├── controller/
│       │       │   ├── UploadController.java
│       │       │   └── UserController.java
│       │       ├── mapper/
│       │       │   └── UserMapper.java
│       │       ├── pojo/
│       │       │   ├── Dept.java
│       │       │   └── User.java
│       │       ├── service/
│       │       │   ├── UserService.java
│       │       │   └── UserServiceImpl.java
│       │       ├── utils/
│       │       │   └── CommonResult.java
│       │       └── JavawebBoot03MybatisApplication.java
│       └── resources/
|           ├── UserMapper.java
│           ├── static/
│           ├── templates/
│           └── application.properties
├── test/
├── target/
├── uploads/
├── .gitattributes
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
└── pom.xml
```
## API Endpoints

| Function | Method | Endpoint | Parameters | Response Format |
|----------|--------|----------|------------|-----------------|
| Create User | POST | `/user` | JSON body | `CommonResult` |
| Update User | PUT | `/user` | JSON body | `CommonResult` |
| Delete User | DELETE | `/user/{id}` | Path variable `id` | `CommonResult` |
| Get User By ID | GET | `/user/{id}` | Path variable `id` | `CommonResult` |
| Get All Users | GET | `/user` | None | `CommonResult` |
| Upload File | POST | `/upload` | `multipart/form-data` | `CommonResult` |

## The problem I met
### MyBatis BindingException
<img height="200" alt="image" src="https://github.com/user-attachments/assets/f6903f4d-84ba-4cbc-b4bb-9ce3fd67f4d7" />

### Reason
Wrong file path in the configuration

```bush
mybatis.mapper-locations=classpath:com/woxueit/boot/mapper/*.xml
```
It means that look for the *com/woxueit/boot/mapper* under the classpath to find the XML file ,but my XML should under the *resources/mapper/* now, so it can not be find

### Solution
#### 1.Move the XML file
From: *src/main/java/com/woxueit/boot/mapper/UserMapper.xml*

To: *src/main/resources/mapper/UserMapper.xml*

#### 2.Modify the configuration file:
```bush
mybatis.mapper-locations=classpath:mapper/*.xml
```

#### 3.Clean and restart
Maven clean: Run mvn clean or click clean in the Maven panel on the right side of IDEA

And then we can rerun the project


