function ReviewDel(n){
	let ok = confirm("정말 삭제 합니까?")
	
	if(ok){
		location.href = "ReviewDelController?no="+n;
		
		
	}
	
}