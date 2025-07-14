<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="display: flex; justify-content: center; align-items: center; min-height: 60vh;">
    <div style="background-color: white; padding: 2rem; border-radius: 10px; box-shadow: 0 2px 20px rgba(0,0,0,0.1); width: 100%; max-width: 400px;">
        <h2 style="text-align: center; color: #2c3e50; margin-bottom: 1.5rem; border-bottom: 2px solid #3498db; padding-bottom: 0.5rem;">
            로그인
        </h2>

        <form action="/user/login" method="post">
            <div style="margin-bottom: 1rem;">
                <label for="username" style="display: block; margin-bottom: 0.5rem; color: #555; font-weight: bold;">
                    사용자명:
                </label>
                <input type="text" id="username" name="username" required 
                       style="width: 100%; padding: 0.75rem; border: 2px solid #ddd; border-radius: 5px; font-size: 1rem; transition: border-color 0.3s;">
            </div>

            <div style="margin-bottom: 1.5rem;">
                <label for="password" style="display: block; margin-bottom: 0.5rem; color: #555; font-weight: bold;">
                    비밀번호:
                </label>
                <input type="password" id="password" name="password" required 
                       style="width: 100%; padding: 0.75rem; border: 2px solid #ddd; border-radius: 5px; font-size: 1rem; transition: border-color 0.3s;">
            </div>

            <button type="submit" 
                    style="width: 100%; padding: 0.75rem; background-color: #3498db; color: white; border: none; border-radius: 5px; font-size: 1rem; cursor: pointer; transition: background-color 0.3s;">
                로그인
            </button>
        </form>

        <div style="text-align: center; margin-top: 1.5rem; padding-top: 1rem; border-top: 1px solid #eee;">
            <a href="/" style="color: #3498db; text-decoration: none; margin-right: 1rem;">홈으로</a>
            <a href="/user/" style="color: #3498db; text-decoration: none;">사용자 관리</a>
        </div>
    </div>
</div>

<style>
input:focus {
    outline: none;
    border-color: #3498db !important;
    box-shadow: 0 0 0 3px rgba(52, 152, 219, 0.1);
}

button:hover {
    background-color: #2980b9 !important;
}

a:hover {
    text-decoration: underline !important;
}
</style>