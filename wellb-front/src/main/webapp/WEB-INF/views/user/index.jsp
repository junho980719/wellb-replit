<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="background-color: white; padding: 2rem; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1);">
    <h2 style="color: #2c3e50; margin-bottom: 1.5rem; border-bottom: 2px solid #3498db; padding-bottom: 0.5rem;">
        사용자 관리
    </h2>

    <p style="font-size: 1.1rem; margin-bottom: 2rem; color: #555;">
        ${message}
    </p>

    <div style="display: grid; grid-template-columns: repeat(auto-fit, minmax(200px, 1fr)); gap: 1rem;">
        <div style="background-color: #f8f9fa; padding: 1.5rem; border-radius: 5px; border-left: 4px solid #3498db;">
            <h3 style="margin-bottom: 0.5rem; color: #2c3e50;">사용자 목록</h3>
            <p style="color: #666; margin-bottom: 1rem;">등록된 모든 사용자를 조회합니다.</p>
            <button style="background-color: #3498db; color: white; border: none; padding: 0.5rem 1rem; border-radius: 3px; cursor: pointer;">
                목록 보기
            </button>
        </div>

        <div style="background-color: #f8f9fa; padding: 1.5rem; border-radius: 5px; border-left: 4px solid #27ae60;">
            <h3 style="margin-bottom: 0.5rem; color: #2c3e50;">사용자 등록</h3>
            <p style="color: #666; margin-bottom: 1rem;">새로운 사용자를 등록합니다.</p>
            <button style="background-color: #27ae60; color: white; border: none; padding: 0.5rem 1rem; border-radius: 3px; cursor: pointer;">
                등록하기
            </button>
        </div>

        <div style="background-color: #f8f9fa; padding: 1.5rem; border-radius: 5px; border-left: 4px solid #e74c3c;">
            <h3 style="margin-bottom: 0.5rem; color: #2c3e50;">권한 관리</h3>
            <p style="color: #666; margin-bottom: 1rem;">사용자 권한을 관리합니다.</p>
            <button style="background-color: #e74c3c; color: white; border: none; padding: 0.5rem 1rem; border-radius: 3px; cursor: pointer;">
                관리하기
            </button>
        </div>
    </div>

    <div style="margin-top: 2rem; text-align: center;">
        <a href="/" style="color: #3498db; text-decoration: none;">← 홈으로 돌아가기</a>
    </div>
</div>