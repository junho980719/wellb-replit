document.addEventListener("DOMContentLoaded", function() {
    var initialUrl = $('#content').data('initial-url');
    if (initialUrl) {
        htmx.ajax('GET', initialUrl, {target: '#content'});
    }
});

document.body.addEventListener('htmx:afterSwap', (event) => {
    if (event.detail.target.id === 'content') {
        updateActiveNav();
    }
});

// 현재 URL 기준으로 active 업데이트 함수
function updateActiveNav() {
    const navItems = document.querySelectorAll('.nav-item');
    const currentPath = window.location.pathname;

    navItems.forEach(item => {
        item.classList.remove('active');
        const anchor = item.querySelector('a');
        if (anchor && anchor.getAttribute('hx-get') === currentPath) {
            item.classList.add('active');
        }
    });
}

    // 페이지 최초 로드 시 active 설정
    updateActiveNav();

// 사용자 정보 관리
let currentUser = {
    name: '홍길동',
    center: '바이젝 월드 피트니스 강남',
    grade: '일반 회원',
    profile: {}
};

// 로그인 상태 관리
let isLoggedIn = true; // 기본값을 true로 설정 (로그인된 상태)

// 페이지 로드 시 초기화
document.addEventListener('DOMContentLoaded', function() {
    initializeLayout();
    loadUserData();
    updateNavigation();
});

// 레이아웃 초기화
function initializeLayout() {
    updateUserGreeting();
    updateCenterInfo();
    setCurrentNavigation();
    
}

// 사용자 데이터 로드
function loadUserData() {
    const savedUser = localStorage.getItem('currentUser');
    if (savedUser) {
        currentUser = JSON.parse(savedUser);
        updateUserGreeting();
        updateCenterInfo();
    }
}

// 사용자 인사말 업데이트
function updateUserGreeting() {
    const greetingElement = document.getElementById('userGreeting');
    if (greetingElement) {
        greetingElement.textContent = `안녕하세요, ${currentUser.name}님!`;
    }
}

// 센터 정보 업데이트
function updateCenterInfo() {
    const centerNameElement = document.getElementById('centerName');
    if (centerNameElement) {
        centerNameElement.textContent = currentUser.center || '센터를 선택하세요';
    }
}

// 네비게이션 활성화 상태 설정
function setActiveNav(navId) {
    document.querySelectorAll('.nav-item').forEach(item => {
        item.classList.remove('active');
    });

    const selectedNav = document.getElementById(navId);
    if (selectedNav) {
        selectedNav.classList.add('active');
    }
}

// 현재 페이지에 따른 네비게이션 설정
function setCurrentNavigation() {
    const currentPage = window.location.pathname.split('/').pop();

    switch(currentPage) {
        case 'index.html':
        case '':
            setActiveNav('navHome');
            break;
        case 'reservation.html':
            setActiveNav('navReservation');
            break;
        case 'attendance.html':
            setActiveNav('navAttendance');
            break;
        case 'mypage.html':
            setActiveNav('navMyPage');
            break;
    }
}

// 네비게이션 업데이트 (알림 배지 등)
function updateNavigation() {
    // 예약 알림 배지 업데이트 예시
    // 실제 구현시 서버에서 알림 개수를 받아와서 설정
}

// 햄버거 메뉴 토글
function toggleHamburgerMenu() {
    const menu = document.getElementById('hamburgerMenu');
    const hamburgerBtn = document.getElementById('hamburgerBtn');
    const hamburgerIcon = hamburgerBtn.querySelector('i');

    menu.classList.toggle('show');

    // 메뉴가 열릴 때 body 스크롤 방지 및 아이콘 변경
    if (menu.classList.contains('show')) {
        document.body.style.overflow = 'hidden';
        // 햄버거 아이콘을 닫기 아이콘으로 변경
        hamburgerIcon.className = 'fas fa-times';
    } else {
        document.body.style.overflow = '';
        // 닫기 아이콘을 햄버거 아이콘으로 변경
        hamburgerIcon.className = 'fas fa-bars';
        // 모든 카테고리 서브메뉴 닫기
        document.querySelectorAll('.category-submenu').forEach(sub => {
            sub.classList.remove('show');
        });
        document.querySelectorAll('.category-header').forEach(header => {
            header.classList.remove('expanded');
        });
    }
}

// 카테고리 토글 함수
function toggleCategory(categoryId, headerElement) {
    const category = document.getElementById(categoryId);
    const isExpanded = category.classList.contains('show');

    // 모든 카테고리 서브메뉴 닫기
    document.querySelectorAll('.category-submenu').forEach(sub => {
        sub.classList.remove('show');
    });

    // 모든 카테고리 헤더의 expanded 클래스 제거
    document.querySelectorAll('.category-header').forEach(header => {
        header.classList.remove('expanded');
    });

    // 클릭된 카테고리가 닫혀있었다면 열기
    if (!isExpanded) {
        category.classList.add('show');
        headerElement.classList.add('expanded');
    }
}

// 아이콘 메뉴 클릭 처리
function handleIconMenuClick(iconId) {
    console.log(`아이콘 메뉴 클릭: ${iconId}`);
    // 여기에 각 아이콘 메뉴에 대한 처리 로직 추가
    toggleHamburgerMenu(); // 메뉴 선택 후 메뉴 닫기
}

// 서브메뉴 아이템 클릭 처리
function handleSubmenuClick(itemId) {
    console.log(`서브메뉴 클릭: ${itemId}`);
    // 여기에 각 서브메뉴 아이템에 대한 처리 로직 추가
    toggleHamburgerMenu(); // 메뉴 선택 후 메뉴 닫기
}

// 간단한 메뉴 아이템 클릭 처리
function handleSimpleMenuClick(itemId) {
    console.log(`간단 메뉴 클릭: ${itemId}`);
    // 여기에 각 간단 메뉴 아이템에 대한 처리 로직 추가
    toggleHamburgerMenu(); // 메뉴 선택 후 메뉴 닫기
}

// 내 수업 서브메뉴 함수들
function goToClassSchedule() {
    console.log('수업 일정 페이지로 이동');
    toggleHamburgerMenu();
}

function goToClassReservation() {
    console.log('수업 예약 페이지로 이동');
    toggleHamburgerMenu();
}

function goToClassHistory() {
    console.log('수업 기록 페이지로 이동');
    toggleHamburgerMenu();
}

function goToClassCancellation() {
    console.log('수업 취소 페이지로 이동');
    toggleHamburgerMenu();
}

// 결제/이용권 서브메뉴 함수들
function goToMembership() {
    console.log('이용권 구매 페이지로 이동');
    toggleHamburgerMenu();
}

function goToPaymentHistory() {
    console.log('결제 내역 페이지로 이동');
    toggleHamburgerMenu();
}

function goToRefund() {
    console.log('환불 신청 페이지로 이동');
    toggleHamburgerMenu();
}

function goToMembershipStatus() {
    console.log('이용권 현황 페이지로 이동');
    toggleHamburgerMenu();
}

// 운동 기록 서브메뉴 함수들
function goToAttendanceRecord() {
    console.log('출석 기록 페이지로 이동');
    toggleHamburgerMenu();
}

function goToExerciseStats() {
    console.log('운동 통계 페이지로 이동');
    toggleHamburgerMenu();
}

function goToBodyComposition() {
    console.log('체성분 기록 페이지로 이동');
    toggleHamburgerMenu();
}

function goToGoalSetting() {
    console.log('목표 설정 페이지로 이동');
    toggleHamburgerMenu();
}

// 커뮤니티 서브메뉴 함수들
function goToNoticeBoard() {
    console.log('공지사항 페이지로 이동');
    toggleHamburgerMenu();
}

function goToFreeBoard() {
    console.log('자유게시판 페이지로 이동');
    toggleHamburgerMenu();
}

function goToEventBoard() {
    console.log('이벤트 페이지로 이동');
    toggleHamburgerMenu();
}

function goToReviewBoard() {
    console.log('수업 후기 페이지로 이동');
    toggleHamburgerMenu();
}

// 설정 서브메뉴 함수들
function goToProfileSettings() {
    console.log('개인정보 수정 페이지로 이동');
    toggleHamburgerMenu();
}

function goToPasswordChange() {
    console.log('비밀번호 변경 페이지로 이동');
    toggleHamburgerMenu();
}

function goToNotificationSettings() {
    console.log('알림 설정 페이지로 이동');
    toggleHamburgerMenu();
}

function goToAppSettings() {
    console.log('앱 설정 페이지로 이동');
    toggleHamburgerMenu();
}

// 고객센터 서브메뉴 함수들
function goToFAQ() {
    console.log('자주 묻는 질문 페이지로 이동');
    toggleHamburgerMenu();
}

function goToInquiry() {
    console.log('1:1 문의 페이지로 이동');
    toggleHamburgerMenu();
}

function goToContactInfo() {
    console.log('연락처 페이지로 이동');
    toggleHamburgerMenu();
}

function goToTerms() {
    console.log('이용약관 페이지로 이동');
    toggleHamburgerMenu();
}



function logout() {
    if (confirm('로그아웃 하시겠습니까?')) {
        console.log('로그아웃 처리');
        localStorage.removeItem('currentUser');
        location.href = '../index.html';
    }
    toggleHamburgerMenu();
}

// 네비게이션 함수들
function goToProfile() {
    console.log('프로필 페이지로 이동');
    // location.href = 'profile.html';
}

function goToReservation() {
    console.log('예약/결제 페이지로 이동');
    // location.href = 'reservation.html';
}

function goToAttendance() {
    console.log('출석/운동 페이지로 이동');
    // location.href = 'attendance.html';
}

function goToMyPage() {
    console.log('마이페이지로 이동');
    // location.href = 'mypage.html';
}

// 유틸리티 함수들
function showLoading(element) {
    element.innerHTML = '<div class="loading-spinner"></div>로딩중...';
}

function hideLoading() {
    document.querySelectorAll('.loading-spinner').forEach(spinner => {
        spinner.remove();
    });
}

function showNotification(message, type = 'info') {
    console.log(`${type}: ${message}`);
}

function formatDate(date) {
    return new Date(date).toLocaleDateString('ko-KR');
}

function formatTime(time) {
    return new Date(time).toLocaleTimeString('ko-KR', {
        hour: '2-digit',
        minute: '2-digit'
    });
}

// 에러 처리
window.addEventListener('error', function(e) {
    console.error('페이지 오류:', e.error);
    showNotification('페이지 로드 중 오류가 발생했습니다.', 'danger');
});

// 오프라인 상태 감지
window.addEventListener('online', function() {
    showNotification('인터넷 연결이 복구되었습니다.', 'success');
});

window.addEventListener('offline', function() {
    showNotification('인터넷 연결이 끊어졌습니다.', 'warning');
});
