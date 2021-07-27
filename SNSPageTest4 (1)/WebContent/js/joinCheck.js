function check(){
	let idjInput = document.joinForm.idj;
	let pwjInput = document.joinForm.pwj;
	let pwj2Input = document.joinForm.pwj2;
	let nInput = document.joinForm.name;
	let birthday = document.joinForm.birthday;
	let introInput = document.joinForm.intro;
	let file = document.joinForm.file;
	let check2 = document.joinForm.check3;
	let idOk = document.joinForm.idOk;
	
	
	

	if (isEmpty(idjInput)) {
		alert('아이디를 입력하세요.');

		idjInput.value = "";
		idjInput.focus();

		return false;
	
	}
	if (containKR(idjInput)) {
		alert('사용할 수 없는 문자입니다.');

		idjInput.value = "";
		idjInput.focus();

		return false;
	
	}
	
	
	if(check4(idOk)){
		alert('존재하는 id');
		
		return false;	
	}
	
	if (isEmpty(pwjInput)) {
		alert('비밀번호를 입력하세요.');

		pwjInput.value = "";
		pwjInput.focus();

		return false;
	
	}
	
	if (notContains(pwjInput, "!@#$%&*")){
	
			alert('특수문자를 입력하세요.');
		
			pwjInput.value = "";
			pwj2Input.value = "";
			pwjInput.focus();
			
			return false;
}
	
	
		if (isEmpty(pwj2Input)) {
		alert('비밀번호가 맞는지 다시한번 확인해주세요.');

		pwj2Input.value = "";
		pwj2Input.focus();

		return false;
	}
	
	if(notEquals(pwjInput, pwj2Input)){
		alert('비밀번호가 서로 다릅니다.')
		
		pwjInput.value="";
		pwj2Input.value="";
		pwjInput.focus();
		
		return false;
	}
	if (isEmpty(nInput)) {
		alert('이름을 입력하세요.');

		nInput.value = "";
		nInput.focus();

		return false;
	
	}
	if (isEmpty(birthday)) {
		alert('생일을 입력하세요.');

		birthday.value = "";
		birthday.focus();

		return false;
	
	}
	
	if (isEmpty(file)) {
		alert('파일을 넣어주세요.');

		file.value = "";
		file.focus();

		return false;
	
	}
	if (isEmpty(introInput)) {
		alert('자기소개를 넣어주세요.');

		introInput.value = "";
		introInput.focus();

		return false;
	
	}

	
}



