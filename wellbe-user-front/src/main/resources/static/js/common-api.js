/**
 * 공통 API 통신 모듈
 */

const API_BASE_URL = 'http://localhost:5000/api';

/**
 * API 요청 공통 함수
 */
async function apiRequest(url, options = {}) {
    const config = {
        headers: {
            'Content-Type': 'application/json',
            ...options.headers
        },
        ...options
    };

    try {
        console.log('API Request:', config.method || 'GET', url, config.body ? JSON.parse(config.body) : '');

        const response = await fetch(`${API_BASE_URL}${url}`, config);
        const data = await response.json();

        console.log('API Response:', data);

        if (!response.ok) {
            throw new Error(data.message || '요청 처리 중 오류가 발생했습니다.');
        }

        return data;
    } catch (error) {
        console.error('API Request Error:', error);
        throw error;
    }
}

/**
 * User API 모듈
 */
const UserAPI = {
    // 회원가입
    async signup(userData) {
        return await apiRequest('/user/signup', {
            method: 'POST',
            body: JSON.stringify(userData)
        });
    },

    // 이메일 중복 체크
    async checkEmail(email) {
        return await apiRequest(`/user/check-email?email=${encodeURIComponent(email)}`);
    },

    // 연락처 중복 체크
    async checkPhone(phone) {
        return await apiRequest(`/user/check-phone?phone=${encodeURIComponent(phone)}`);
    }
};

/**
 * 전역 객체로 등록
 */
window.UserAPI = UserAPI;