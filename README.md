ToDo






```
.
├── mvnw
├── mvnw.cmd
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── todo
│   │   │           ├── ToDoListApplication.java
│   │   │           ├── controller
│   │   │           │   ├── MainController.java
│   │   │           │   ├── PersonalTodoController.java
│   │   │           │   ├── TeamTodoController.java
│   │   │           │   └── TeamTodoRestController.java
│   │   │           ├── entity
│   │   │           │   ├── TodoEntity1.java
│   │   │           │   ├── TodoEntity2.java
│   │   │           │   └── TodoEntity3.java
│   │   │           ├── repositories
│   │   │           │   ├── PersonalTodoRepository.java
│   │   │           │   ├── TeamTodoRepository.java
│   │   │           │   └── TodoRepository_1.java
│   │   │           ├── security
│   │   │           │   ├── controller
│   │   │           │   │   ├── JwtLoginApiController.java
│   │   │           │   │   └── SessionLoginController.java
│   │   │           │   ├── dto
│   │   │           │   │   ├── JoinRequest.java
│   │   │           │   │   └── LoginRequest.java
│   │   │           │   ├── entity
│   │   │           │   │   └── User.java
│   │   │           │   ├── filter
│   │   │           │   │   └── JwtTokenFilter.java
│   │   │           │   ├── repositories
│   │   │           │   │   └── UserRepository.java
│   │   │           │   ├── service
│   │   │           │   │   └── UserService.java
│   │   │           │   ├── springsecurity
│   │   │           │   │   ├── AppConfig.java
│   │   │           │   │   └── SecurityConfig.java
│   │   │           │   ├── userrole
│   │   │           │   │   └── UserRole.java
│   │   │           │   └── utils
│   │   │           │       └── JwtTokenUtil.java
│   │   │           └── service
│   │   │               ├── PersonalTodoService.java
│   │   │               ├── PersonalTodoServiceImpl.java
│   │   │               ├── TeamTodoService.java
│   │   │               ├── TeamTodoServiceImpl.java
│   │   │               ├── TodoService1.java
│   │   │               └── TodoServiceImpl1.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── js
│   │       │   ├── nn.js
│   │       │   └── nn.js:Zone.Identifier
│   │       ├── static
│   │       │   ├── asd.css
│   │       │   └── images
│   │       │       ├── a1.jpeg
│   │       │       ├── a2.jpeg
│   │       │       ├── aaa.png
│   │       │       ├── logo.png
│   │       │       └── todo.logo.png
│   │       └── templates
│   │           ├── Todo.html
│   │           ├── Todo_admin.html
│   │           ├── admin.html
│   │           ├── info.html
│   │           ├── info_admin.html
│   │           ├── join.html
│   │           ├── login.html
│   │           ├── login_origin.html
│   │           ├── logout.html
│   │           ├── teamtodo.html
│   │           └── teamtodo_admin.html
│   └── test
│       └── java
│           └── com
│               └── todo
│                   └── ToDoListApplicationTests.java
└── target
    ├── ToDoList-0.0.1-SNAPSHOT.jar
    ├── ToDoList-0.0.1-SNAPSHOT.jar.original
    ├── ToDoList-0.0.1-SNAPSHOT.jar:Zone.Identifier
    ├── classes
    │   ├── META-INF
    │   │   ├── MANIFEST.MF
    │   │   └── maven
    │   │       └── com.todo
    │   │           └── ToDoList
    │   │               ├── pom.properties
    │   │               └── pom.xml
    │   ├── application.properties
    │   ├── com
    │   │   └── todo
    │   │       ├── ToDoListApplication.class
    │   │       ├── controller
    │   │       │   ├── MainController.class
    │   │       │   ├── PersonalTodoController.class
    │   │       │   ├── TeamTodoController.class
    │   │       │   └── TeamTodoRestController.class
    │   │       ├── entity
    │   │       │   ├── TodoEntity1.class
    │   │       │   ├── TodoEntity2.class
    │   │       │   └── TodoEntity3.class
    │   │       ├── repositories
    │   │       │   ├── PersonalTodoRepository.class
    │   │       │   ├── TeamTodoRepository.class
    │   │       │   └── TodoRepository_1.class
    │   │       ├── security
    │   │       │   ├── controller
    │   │       │   │   └── SessionLoginController.class
    │   │       │   ├── dto
    │   │       │   │   ├── JoinRequest.class
    │   │       │   │   └── LoginRequest.class
    │   │       │   ├── entity
    │   │       │   │   ├── User$UserBuilder.class
    │   │       │   │   └── User.class
    │   │       │   ├── filter
    │   │       │   ├── repositories
    │   │       │   │   └── UserRepository.class
    │   │       │   ├── service
    │   │       │   │   └── UserService.class
    │   │       │   ├── springsecurity
    │   │       │   │   ├── AppConfig.class
    │   │       │   │   └── SecurityConfig.class
    │   │       │   ├── userrole
    │   │       │   │   └── UserRole.class
    │   │       │   └── utils
    │   │       └── service
    │   │           ├── PersonalTodoService.class
    │   │           ├── PersonalTodoServiceImpl.class
    │   │           ├── TeamTodoService.class
    │   │           ├── TeamTodoServiceImpl.class
    │   │           ├── TodoService1.class
    │   │           └── TodoServiceImpl1.class
    │   ├── js
    │   │   ├── nn.js
    │   │   └── nn.js:Zone.Identifier
    │   ├── static
    │   │   ├── asd.css
    │   │   └── images
    │   │       ├── a1.jpeg
    │   │       ├── a2.jpeg
    │   │       ├── aaa.png
    │   │       ├── logo.png
    │   │       └── todo.logo.png
    │   └── templates
    │       ├── Todo.html
    │       ├── Todo_admin.html
    │       ├── admin.html
    │       ├── info.html
    │       ├── info_admin.html
    │       ├── join.html
    │       ├── login.html
    │       ├── login_origin.html
    │       ├── logout.html
    │       ├── teamtodo.html
    │       └── teamtodo_admin.html
    ├── generated-sources
    │   └── annotations
    ├── generated-test-sources
    │   └── test-annotations
    ├── maven-archiver
    │   └── pom.properties
    ├── maven-status
    │   └── maven-compiler-plugin
    │       ├── compile
    │       │   └── default-compile
    │       │       ├── createdFiles.lst
    │       │       └── inputFiles.lst
    │       └── testCompile
    │           └── default-testCompile
    │               ├── createdFiles.lst
    │               └── inputFiles.lst
    ├── surefire-reports
    │   ├── TEST-com.todo.ToDoListApplicationTests.xml
    │   └── com.todo.ToDoListApplicationTests.txt
    └── test-classes
        └── com
            └── todo
                └── ToDoListApplicationTests.class
```
