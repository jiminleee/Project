
function check2() {
	
	let name = document.getElementById("name");
    let birth = document.getElementById("birth"); 	

    let date = new Date();
    let year = date.getFullYear();
    let age = year - birth.value; 
    let name2 = name.value;
	
	if (name.value == '') {
        alert("아이디를 입력해주십시오");
        name.focus();
        return false;
    }

    if (birth.value == '') {
        alert("비밀번호를 입력해주십시오");
        birth.focus();
        return false;
    }
	
	 document.write(
        name2 + '(' + age + ')님 안녕하세요'
    );




}