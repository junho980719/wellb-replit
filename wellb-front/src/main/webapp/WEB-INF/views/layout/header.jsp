
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
    <nav style="display: flex; justify-content: space-between; align-items: center;">
        <div>
            <h1 style="margin: 0;">
                <a href="/" style="color: white; text-decoration: none;">Wellb System</a>
            </h1>
        </div>
        <div>
            <ul style="list-style: none; display: flex; gap: 2rem; margin: 0;">
                <li>
                    <a href="/" style="color: white; text-decoration: none; padding: 0.5rem 1rem; border-radius: 4px; transition: background-color 0.3s;">
                        홈
                    </a>
                </li>
                <li>
                    <a href="/user/" style="color: white; text-decoration: none; padding: 0.5rem 1rem; border-radius: 4px; transition: background-color 0.3s;">
                        사용자 관리
                    </a>
                </li>
                <li>
                    <a href="/user/login" style="color: white; text-decoration: none; padding: 0.5rem 1rem; border-radius: 4px; transition: background-color 0.3s;">
                        로그인
                    </a>
                </li>
            </ul>
        </div>
    </nav>
</div>

<style>
nav a:hover {
    background-color: rgba(255,255,255,0.1) !important;
}
</style>
