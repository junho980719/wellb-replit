# WELL-BE Local Test Memory DB Set

## 1. 빌드
docker build -f Dockerfile-h2 -t h2-db .

## 2. 실행
docker run -d -p 9092:1521 -p 8082:81 -v D:\workspace\h2-data:/opt/h2-data --name h2 h2-db

## multi application DB Connect
```
+------------+      +------------+
| Admin API  | ---> | H2 TCP 9092 |
+------------+      +------------+

+------------+          |
| User API   | ---------+
+------------+
```