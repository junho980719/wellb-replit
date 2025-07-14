<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="text-align: center; padding: 2rem;">
    <h2 style="color: #2c3e50; margin-bottom: 1rem;">환영합니다!</h2>
    <p style="font-size: 1.2rem; margin-bottom: 2rem;">${message}</p>

    <div style="display: flex; justify-content: center; gap: 1rem; flex-wrap: wrap;">
        <a href="/user/" style="background-color: #3498db; color: white; padding: 1rem 2rem; text-decoration: none; border-radius: 5px; transition: background-color 0.3s;">
            사용자 관리
        </a>
        <a href="/user/login" style="background-color: #27ae60; color: white; padding: 1rem 2rem; text-decoration: none; border-radius: 5px; transition: background-color 0.3s;">
            로그인
        </a>
    </div>
</div>

<style>
a:hover {
    opacity: 0.9;
}
</style>