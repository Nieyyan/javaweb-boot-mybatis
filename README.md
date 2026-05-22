# Javaweb-boot-mybatis

## Tech Stack
Springboot 4.0.6

MyBatis 4.0.1

MySQL 8.0+

Java 17

Maven 3.8+

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
│       │       │   ├── UserMapper.java
│       │       │   └── UserMapper.xml
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
#### 1.MyBatis BindingException
<img height="200" alt="image" src="https://github.com/user-attachments/assets/f6903f4d-84ba-4cbc-b4bb-9ce3fd67f4d7" />

### Reason

### Solution
