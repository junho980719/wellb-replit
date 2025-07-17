# WELL-BE Local Test MYSQL Set

## 1. 빌드
docker build -t wellbe-mysql .

## 2. 실행
docker run -d -p 3306:3306 -v D:\workspace\mysql-data:/var/lib/mysql --name wellbe-db wellbe-mysql


## multi application DB Connect
```
+------------+      +------------+
| Admin API  | ---> | MYSQL 3306 |
+------------+      +------------+

+------------+          |
| User API   | ---------+
+------------+
```