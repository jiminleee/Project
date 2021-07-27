/**
 * 
 */




function delBookmark(n) {
	
	let ok = confirm('북마크를 해제하시겠습니까?');
	
	if(ok) {
		location.href='DelBMController?no='+n;
	}	

	
}

function insertBookmark(n) {
	
	let ok2 = confirm('북마크로 추가하시겠습니까?');
	
	if(ok2) {
		location.href='InsertBMController?no='+n;
	}


}