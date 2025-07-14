
/**
 * 공통 API 통신 유틸리티
 */
class ApiUtil {
    /**
     * 기본 API 요청 함수
     * @param {string} url - 요청할 URL
     * @param {Object} options - 요청 옵션
     * @returns {Promise} - fetch 응답 Promise
     */
    static async request(url, options = {}) {
        const defaultOptions = {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            credentials: 'same-origin'
        };

        // 옵션 병합
        const finalOptions = {
            ...defaultOptions,
            ...options,
            headers: {
                ...defaultOptions.headers,
                ...options.headers
            }
        };

        // POST/PUT/PATCH 요청이고 body가 객체인 경우 JSON으로 변환
        if (['POST', 'PUT', 'PATCH'].includes(finalOptions.method) && 
            finalOptions.body && 
            typeof finalOptions.body === 'object' && 
            !(finalOptions.body instanceof FormData)) {
            finalOptions.body = JSON.stringify(finalOptions.body);
        }

        try {
            const response = await fetch(url, finalOptions);
            
            // 응답이 JSON인지 확인
            const contentType = response.headers.get('content-type');
            let data;
            
            if (contentType && contentType.includes('application/json')) {
                data = await response.json();
            } else {
                data = await response.text();
            }

            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}, message: ${data}`);
            }

            return {
                success: true,
                data: data,
                status: response.status,
                headers: response.headers
            };
        } catch (error) {
            console.error('API Request Error:', error);
            return {
                success: false,
                error: error.message,
                status: error.status || 500
            };
        }
    }

    /**
     * GET 요청
     */
    static get(url, options = {}) {
        return this.request(url, { ...options, method: 'GET' });
    }

    /**
     * POST 요청
     */
    static post(url, data = null, options = {}) {
        return this.request(url, { 
            ...options, 
            method: 'POST', 
            body: data 
        });
    }

    /**
     * PUT 요청
     */
    static put(url, data = null, options = {}) {
        return this.request(url, { 
            ...options, 
            method: 'PUT', 
            body: data 
        });
    }

    /**
     * DELETE 요청
     */
    static delete(url, options = {}) {
        return this.request(url, { ...options, method: 'DELETE' });
    }

    /**
     * 파일 업로드 요청
     */
    static uploadFile(url, formData, options = {}) {
        const uploadOptions = {
            ...options,
            method: 'POST',
            body: formData,
            headers: {
                // FormData 사용시 Content-Type 헤더를 제거하여 브라우저가 자동 설정하도록 함
                ...options.headers
            }
        };
        
        // Content-Type 제거
        delete uploadOptions.headers['Content-Type'];
        
        return this.request(url, uploadOptions);
    }
}

// 전역으로 사용할 수 있도록 window 객체에 추가
window.ApiUtil = ApiUtil;
