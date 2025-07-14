
/**
 * 공통 UI 유틸리티
 */
class UIUtil {
    
    /**
     * 커스텀 Alert 표시
     * @param {string} message - 알림 메시지
     * @param {string} type - 알림 타입 (success, error, warning, info)
     * @param {function} callback - 확인 버튼 클릭시 실행할 콜백 함수
     */
    static showAlert(message, type = 'info', callback = null) {
        // 기존 알림창이 있으면 제거
        const existingAlert = document.getElementById('custom-alert');
        if (existingAlert) {
            existingAlert.remove();
        }

        const alertHtml = `
            <div id="custom-alert" class="custom-alert-overlay">
                <div class="custom-alert-box ${type}">
                    <div class="custom-alert-icon">
                        ${this.getAlertIcon(type)}
                    </div>
                    <div class="custom-alert-message">${message}</div>
                    <div class="custom-alert-buttons">
                        <button class="custom-alert-btn" onclick="UIUtil.closeAlert()">확인</button>
                    </div>
                </div>
            </div>
        `;

        document.body.insertAdjacentHTML('beforeend', alertHtml);
        
        // 애니메이션을 위해 약간의 지연
        setTimeout(() => {
            const alertElement = document.getElementById('custom-alert');
            if (alertElement) {
                alertElement.classList.add('show');
            }
        }, 10);

        // 콜백 함수 저장
        if (callback) {
            window.customAlertCallback = callback;
        }
    }

    /**
     * 커스텀 Alert 닫기
     */
    static closeAlert() {
        const alertElement = document.getElementById('custom-alert');
        if (alertElement) {
            alertElement.classList.remove('show');
            setTimeout(() => {
                alertElement.remove();
                // 콜백 함수가 있으면 실행
                if (window.customAlertCallback) {
                    window.customAlertCallback();
                    window.customAlertCallback = null;
                }
            }, 300);
        }
    }

    /**
     * 알림 타입별 아이콘 반환
     */
    static getAlertIcon(type) {
        const icons = {
            success: '✓',
            error: '✕',
            warning: '⚠',
            info: 'ℹ'
        };
        return icons[type] || icons.info;
    }

    /**
     * Layer Popup 열기 (HTMX 사용)
     * @param {string} url - 팝업 컨텐츠를 로드할 URL
     * @param {Object} options - 팝업 옵션
     */
    static openLayerPopup(url, options = {}) {
        const defaultOptions = {
            width: '500px',
            height: 'auto',
            closable: true,
            backdrop: true
        };

        const finalOptions = { ...defaultOptions, ...options };

        // 기존 팝업이 있으면 제거
        this.closeLayerPopup();

        const popupHtml = `
            <div id="layer-popup" class="layer-popup-overlay" ${finalOptions.backdrop ? 'onclick="UIUtil.closeLayerPopup()"' : ''}>
                <div class="layer-popup-box" style="width: ${finalOptions.width}; height: ${finalOptions.height}" onclick="event.stopPropagation()">
                    ${finalOptions.closable ? '<button class="layer-popup-close" onclick="UIUtil.closeLayerPopup()">×</button>' : ''}
                    <div class="layer-popup-content" 
                         hx-get="${url}" 
                         hx-trigger="load"
                         hx-indicator=".popup-loading">
                        <div class="popup-loading htmx-indicator">
                            <div class="spinner"></div>
                            <p>로딩 중...</p>
                        </div>
                    </div>
                </div>
            </div>
        `;

        document.body.insertAdjacentHTML('beforeend', popupHtml);
        
        // 애니메이션을 위해 약간의 지연
        setTimeout(() => {
            const popupElement = document.getElementById('layer-popup');
            if (popupElement) {
                popupElement.classList.add('show');
                // HTMX 트리거
                htmx.process(popupElement);
            }
        }, 10);
    }

    /**
     * Layer Popup 닫기
     */
    static closeLayerPopup() {
        const popupElement = document.getElementById('layer-popup');
        if (popupElement) {
            popupElement.classList.remove('show');
            setTimeout(() => {
                popupElement.remove();
            }, 300);
        }
    }

    /**
     * 로딩 스피너 표시
     */
    static showLoading(message = '처리 중...') {
        const existingLoading = document.getElementById('global-loading');
        if (existingLoading) {
            existingLoading.remove();
        }

        const loadingHtml = `
            <div id="global-loading" class="global-loading-overlay">
                <div class="global-loading-box">
                    <div class="spinner"></div>
                    <p>${message}</p>
                </div>
            </div>
        `;

        document.body.insertAdjacentHTML('beforeend', loadingHtml);
        
        setTimeout(() => {
            const loadingElement = document.getElementById('global-loading');
            if (loadingElement) {
                loadingElement.classList.add('show');
            }
        }, 10);
    }

    /**
     * 로딩 스피너 숨기기
     */
    static hideLoading() {
        const loadingElement = document.getElementById('global-loading');
        if (loadingElement) {
            loadingElement.classList.remove('show');
            setTimeout(() => {
                loadingElement.remove();
            }, 300);
        }
    }

    /**
     * 토스트 알림 표시
     */
    static showToast(message, type = 'info', duration = 3000) {
        const toastHtml = `
            <div class="toast toast-${type}">
                <div class="toast-icon">${this.getAlertIcon(type)}</div>
                <div class="toast-message">${message}</div>
            </div>
        `;

        let toastContainer = document.getElementById('toast-container');
        if (!toastContainer) {
            toastContainer = document.createElement('div');
            toastContainer.id = 'toast-container';
            toastContainer.className = 'toast-container';
            document.body.appendChild(toastContainer);
        }

        toastContainer.insertAdjacentHTML('beforeend', toastHtml);
        
        const toastElement = toastContainer.lastElementChild;
        
        // 애니메이션
        setTimeout(() => {
            toastElement.classList.add('show');
        }, 10);

        // 자동 제거
        setTimeout(() => {
            toastElement.classList.remove('show');
            setTimeout(() => {
                toastElement.remove();
                // 컨테이너가 비어있으면 제거
                if (toastContainer.children.length === 0) {
                    toastContainer.remove();
                }
            }, 300);
        }, duration);
    }
}

// 전역으로 사용할 수 있도록 window 객체에 추가
window.UIUtil = UIUtil;
