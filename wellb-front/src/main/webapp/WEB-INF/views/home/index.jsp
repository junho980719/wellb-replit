
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Wellb Front</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 50px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            text-align: center;
        }
        .message {
            text-align: center;
            font-size: 18px;
            color: #666;
            margin-top: 20px;
        }
        .nav {
            text-align: center;
            margin-top: 30px;
        }
        .nav a {
            display: inline-block;
            margin: 0 10px;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .nav a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Wellb Frontend</h1>
        <div class="message">${message}</div>
        <p>Spring Boot + JSP 환경이 정상적으로 구성되었습니다.</p>
        <p>포트: 8080</p>
        
        <div class="nav">
            <a href="/user/">사용자 관리</a>
            <a href="/user/login">로그인</a>
        </div>
    </div>
</body>
</html>
