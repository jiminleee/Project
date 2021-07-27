function DelProfile(i) {
	let ok = confirm('회원 탈퇴시 모든 정보가 삭제됩니다.');

	if (ok) {
		location.href = 'DelProfileController?id=' + i;
	}else{
	return false;
	}

}