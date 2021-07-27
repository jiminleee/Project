function deleteText(n) {
	
	let ok2 = confirm('삭제하시겠습니까?');
	
	if(ok2) {
		
		location.href = 'DelController?no=' + n;
		
	}
	
}

