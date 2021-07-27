function deleteMovie(n){
	let ok = confirm("정말 삭제 합니까?")
	
	if(ok){
		location.href = "MovieDelController?no="+n;
		
		
	}
	
}